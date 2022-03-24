package com.kyle.tasksapp.ui.taskadd

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.kyle.tasksapp.R
import com.kyle.tasksapp.databinding.FragmentAddTaskBinding
import com.kyle.tasksapp.util.exhaustive
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

// Implements the logic to the FAB to add tasks to the database
// Implements the logic to click on tasks and edit them and their states

@AndroidEntryPoint
class TaskAddFragment : Fragment(R.layout.fragment_add_task) {
    private val viewModel: TaskAddViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentAddTaskBinding.bind(view)
        binding.apply {
            textEditTask.setText(viewModel.taskName)
            checkboxImportant.isChecked = viewModel.taskImportance
            checkboxImportant.jumpDrawablesToCurrentState()
            textViewTimestamp.isVisible = viewModel.task != null
            textViewTimestamp.text = "Created: ${viewModel.task?.timestampFormatted}"

            textEditTask.addTextChangedListener {
                viewModel.taskName = it.toString()
            }

            checkboxImportant.setOnCheckedChangeListener {_, isChecked ->
                viewModel.taskImportance = isChecked
            }

            fabSaveTask.setOnClickListener {
                viewModel.saveClick()
            }
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.taskUpdateEvent.collect { event ->
                when(event) {
                    is TaskAddViewModel.TaskUpdateEvent.ShowInvalidInputMsg -> {
                        Snackbar.make(requireView(), event.msg, Snackbar.LENGTH_LONG).show()
                    }
                    is TaskAddViewModel.TaskUpdateEvent.GoBack -> {
                        binding.textEditTask.clearFocus()
                        setFragmentResult("update_request", bundleOf("update_result" to event.result))
                        findNavController().popBackStack()
                    }
                }
            }.exhaustive
        }
    }
}