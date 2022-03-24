package com.kyle.tasksapp.ui.tasks

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.kyle.tasksapp.data.PreferencesRepo
import com.kyle.tasksapp.data.SortOrder
import com.kyle.tasksapp.data.Task
import com.kyle.tasksapp.data.TaskDao
import com.kyle.tasksapp.ui.TASK_ADD_RESULT_ALLOWED
import com.kyle.tasksapp.ui.TASK_EDIT_RESULT_ALLOWED
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class TasksViewModel @ViewModelInject constructor(
    private val taskDao: TaskDao,
    private val preferencesRepo: PreferencesRepo,
    @Assisted private val state: SavedStateHandle
) : ViewModel() {
    val searchQuery = state.getLiveData("searchQuery", "")
    val preferencesFlow = preferencesRepo.preferencesFlow

    // If public the fragment could put data into the channel = not good
    // Only want to take data out
    private val tasksEventChannel = Channel<TasksEvent>()
    val tasksEvent = tasksEventChannel.receiveAsFlow()

    //
    private val taskFlow = combine(
        searchQuery.asFlow(),
        preferencesFlow
    ) { query, filterPreferences ->
        Pair(query, filterPreferences)
    }.flatMapLatest { (query, filterPreferences) ->
        taskDao.getTasks(query, filterPreferences.sortOrder, filterPreferences.hideCompleted)
    }

    val tasks = taskFlow.asLiveData()

    // List of functions which perform the corresponding tasks through Kotlin coroutines
    // Each coroutine is async within a specific scope (fast, memory efficient)

    fun onSortOrder(sortOrder: SortOrder) = viewModelScope.launch {
        preferencesRepo.updateSortOrder(sortOrder)
    }

    fun onHideCompleted(hideCompleted: Boolean) = viewModelScope.launch {
        preferencesRepo.updateHideCompleted(hideCompleted)
    }

    fun taskSelected(task: Task) = viewModelScope.launch {
        tasksEventChannel.send(TasksEvent.GoToEditTask(task))
    }

    fun taskChecked(task: Task, isChecked: Boolean) = viewModelScope.launch {
        taskDao.update(task.copy(completed = isChecked))
    }

    fun undoDelete(task: Task) = viewModelScope.launch {
        taskDao.insert(task)
    }

    fun addNewTask() = viewModelScope.launch {
        tasksEventChannel.send(TasksEvent.GoToAddTask)
    }

    fun deleteCompleted() = viewModelScope.launch {
        tasksEventChannel.send(TasksEvent.GoToDeleteCompleted)
    }

    private fun taskSavedMsg(text: String) = viewModelScope.launch {
        tasksEventChannel.send(TasksEvent.TaskSavedMsg(text))
    }

    fun updateResult(result: Int) {
        when(result) {
            TASK_ADD_RESULT_ALLOWED -> taskSavedMsg("Task Created")
            TASK_EDIT_RESULT_ALLOWED -> taskSavedMsg("Task Updated")
        }
    }

    fun taskSwiped(task: Task) = viewModelScope.launch {
        taskDao.delete(task)
        tasksEventChannel.send(TasksEvent.ShowUndoMsg(task))
    }

    // Like an enum but can hold data
    sealed class TasksEvent {
        // Set object so it does not create unwanted instances
        object GoToAddTask: TasksEvent()
        object GoToDeleteCompleted: TasksEvent()
        data class GoToEditTask(val task: Task): TasksEvent()
        data class ShowUndoMsg(val task: Task): TasksEvent()
        data class TaskSavedMsg(val msg: String): TasksEvent()
    }
}