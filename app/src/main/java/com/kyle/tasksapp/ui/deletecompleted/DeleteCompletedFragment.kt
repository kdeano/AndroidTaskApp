package com.kyle.tasksapp.ui.deletecompleted

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DeleteCompletedFragment : DialogFragment() {
    private val viewModel: DeleteCompletedViewModel by viewModels()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setTitle("Confirm deletion")
            .setMessage("Do you want to delete all completed tasks?")
            .setNegativeButton("Cancel", null)
            .setPositiveButton("Confirm") {_, _ ->
                // call viewModel to confirm delete
                viewModel.confirm()
            }
            .create()
}