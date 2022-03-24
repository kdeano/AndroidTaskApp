package com.kyle.tasksapp.ui.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kyle.tasksapp.data.Task
import com.kyle.tasksapp.databinding.ItemTaskBinding

// Class which knows how to put the correct data inside the RecyclerView
// Knows how to transfer the database items into the correct place
// Uses view binding to distinguish where data should be placed in the viewmodel

class TasksAdapter(private val listener: ItemClicked) : ListAdapter<Task, TasksAdapter.TasksViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TasksViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    // Breaks if 'inner' is not added
    inner class TasksViewHolder(private val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.apply {
                root.setOnClickListener {
                    val position = adapterPosition
                    if(position != RecyclerView.NO_POSITION) {
                        val task = getItem(position)
                        listener.onItemClick(task)
                    }
                }
                checkboxCompleted.setOnClickListener {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        val task = getItem(position)
                        listener.onCheckboxClick(task, checkboxCompleted.isChecked)
                    }
                }
            }
        }

        // Binds specific data to the correct place in the viewmodel
        fun bind(task: Task) {
            binding.apply {
                checkboxCompleted.isChecked = task.completed
                textViewName.text = task.task
                textViewName.paint.isStrikeThruText = task.completed
                imgImportant.isVisible = task.important
            }
        }
    }

    interface ItemClicked {
        fun onItemClick(task: Task)
        fun onCheckboxClick(task: Task, isChecked: Boolean)
    }

    class DiffCallback : DiffUtil.ItemCallback<Task>() {
        override fun areItemsTheSame(oldItem: Task, newItem: Task) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Task, newItem: Task) =
            oldItem == newItem
    }
}