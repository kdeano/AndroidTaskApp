package com.kyle.tasksapp.ui.tasks

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.kyle.tasksapp.R
import com.kyle.tasksapp.data.SortOrder
import com.kyle.tasksapp.data.Task
import com.kyle.tasksapp.databinding.FragmentTasksBinding
import com.kyle.tasksapp.util.exhaustive
import com.kyle.tasksapp.util.onTextChanged
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class TasksFragment : Fragment(R.layout.fragment_tasks), TasksAdapter.ItemClicked {
    private val viewModel: TasksViewModel by viewModels()

    // Make searchView a property to fix screen orientation fragment destroy bug
    // Bug causes search query to be active even when search bar is closed upon screen rotate
    private lateinit var searchView: SearchView

    @OptIn(InternalCoroutinesApi::class)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentTasksBinding.bind(view)
        val taskAdapter = TasksAdapter(this)

        binding.apply {
            recyclerViewTasks.apply {
                adapter = taskAdapter
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
            }

            ItemTouchHelper(object: ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false    // onMove will not be called
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val task = taskAdapter.currentList[viewHolder.adapterPosition]
                    viewModel.taskSwiped(task)
                }
            }).attachToRecyclerView(recyclerViewTasks)

            fabAddTask.setOnClickListener {
                viewModel.addNewTask()
            }
        }

        setFragmentResultListener("update_request") {_, bundle ->
            val result = bundle.getInt("update_result")
            viewModel.updateResult(result)
        }

        viewModel.tasks.observe(viewLifecycleOwner) {
            taskAdapter.submitList(it)
        }

        // As soon as fragment is not visible - stop listening for events
        // Channel will suspend and start only when the fragment is visible again
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.tasksEvent.collect { event ->
                when(event) {
                    is TasksViewModel.TasksEvent.ShowUndoMsg -> {
                        Snackbar.make(requireView(), "Task deleted", Snackbar.LENGTH_LONG).setAction("UNDO") {
                            viewModel.undoDelete(event.task)
                        }.show()
                    }
                    is TasksViewModel.TasksEvent.GoToAddTask -> {
                        val input = TasksFragmentDirections.actionTasksFragmentToTaskAddFragment(null, "Create Task")
                        findNavController().navigate(input) // Compile time safety rather than passing fragment directly
                    }
                    is TasksViewModel.TasksEvent.GoToEditTask -> {
                        val input = TasksFragmentDirections.actionTasksFragmentToTaskAddFragment(event.task, "View | Edit Task")    // Passes the task clicked as an argument to select it
                        findNavController().navigate(input)
                    }
                    is TasksViewModel.TasksEvent.TaskSavedMsg -> Snackbar.make(requireView(), event.msg, Snackbar.LENGTH_SHORT).show()
                    is TasksViewModel.TasksEvent.GoToDeleteCompleted -> {
                        val action = TasksFragmentDirections.actionGlobalDeleteCompletedFragment()
                        findNavController().navigate(action)
                    }
                }.exhaustive
            }
        }

        setHasOptionsMenu(true)
    }

    // View model changes to selected task
    override fun onItemClick(task: Task) {
        viewModel.taskSelected(task)
    }

    // Displays only important tasks if checkbox is clicked and vice versa
    override fun onCheckboxClick(task: Task, isChecked: Boolean) {
        viewModel.taskChecked(task, isChecked)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.fragment_menu_tasks, menu)

        // Searches through tasks on search click
        val searchTask = menu.findItem(R.id.input_search)
        searchView = searchTask.actionView as SearchView

        // Logic to check if there is a pending query in search bar
        // and expands view to keep search active
        val pendingQuery = viewModel.searchQuery.value
        if(pendingQuery != null && pendingQuery.isNotEmpty()) {
            searchTask.expandActionView()
            searchView.setQuery(pendingQuery, false)
        }

        // Implements the view extensions class
        searchView.onTextChanged {
            viewModel.searchQuery.value = it
        }

        viewLifecycleOwner.lifecycleScope.launch {
            menu.findItem(R.id.input_completed_hide).isChecked = viewModel.preferencesFlow.first().hideCompleted
        }
    }

    // Calls viewModel functions on specific item clicks
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.input_sort_name -> {
                viewModel.onSortOrder(SortOrder.BY_NAME)
                true
            }
            R.id.input_sort_by_date -> {
                viewModel.onSortOrder(SortOrder.BY_DATE)
                true
            }
            R.id.input_completed_hide -> {
                item.isChecked = !item.isChecked
                viewModel.onHideCompleted(item.isChecked)
                true
            }
            R.id.input_delete_completed -> {
                viewModel.deleteCompleted()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // Empty string no longer sent to query listener when screen is rotated
    override fun onDestroyView() {
        super.onDestroyView()
        searchView.setOnQueryTextListener(null)
    }
}
