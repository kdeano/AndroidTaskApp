package com.kyle.tasksapp.ui.taskadd

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kyle.tasksapp.data.Task
import com.kyle.tasksapp.data.TaskDao
import com.kyle.tasksapp.ui.TASK_ADD_RESULT_ALLOWED
import com.kyle.tasksapp.ui.TASK_EDIT_RESULT_ALLOWED
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class TaskAddViewModel @ViewModelInject constructor(
    private val taskDao: TaskDao,
    @Assisted private val state: SavedStateHandle
) : ViewModel() {
    val task = state.get<Task>("task")
    var taskName = state.get<String>("taskName") ?: task?.task ?: ""
        set(value) {
            field = value
            state.set("taskName", value)
        }

    var taskImportance = state.get<Boolean>("taskImportance") ?: task?.important ?: false
        set(value) {
            field = value
            state.set("taskImportance", value)
        }

    private val taskUpdateChannel = Channel<TaskUpdateEvent>()
    val taskUpdateEvent = taskUpdateChannel.receiveAsFlow()

    fun saveClick() {
        if (taskName.isBlank()) {   // Invalid input - needs to have text
            showInvalidInputMsg("Task name cannot be empty")
            return
        }

        // Data stored in DB is immutable so new tasks have to be stored rather than old ones edited
        if (task != null) {
            val updatedTask = task.copy(task = taskName, important = taskImportance)
            updateTask(updatedTask)
        } else {
            val newTask = Task(task = taskName, important = taskImportance)
            createTask(newTask)
        }
    }

    private fun showInvalidInputMsg(text: String) = viewModelScope.launch {
        taskUpdateChannel.send(TaskUpdateEvent.ShowInvalidInputMsg(text))
    }

    private fun createTask(task: Task) = viewModelScope.launch {
        taskDao.insert(task)
        taskUpdateChannel.send(TaskUpdateEvent.GoBack(TASK_ADD_RESULT_ALLOWED))
    }

    private fun updateTask(task: Task) = viewModelScope.launch {
        taskDao.update(task)
        taskUpdateChannel.send(TaskUpdateEvent.GoBack(TASK_EDIT_RESULT_ALLOWED))
    }

    sealed class TaskUpdateEvent {
        data class ShowInvalidInputMsg(val msg: String): TaskUpdateEvent()
        data class GoBack(val result: Int): TaskUpdateEvent()
    }
}