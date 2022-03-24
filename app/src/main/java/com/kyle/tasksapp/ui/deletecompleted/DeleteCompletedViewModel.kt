package com.kyle.tasksapp.ui.deletecompleted

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kyle.tasksapp.data.TaskDao
import com.kyle.tasksapp.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class DeleteCompletedViewModel @ViewModelInject constructor(
    private val taskDao: TaskDao,
    @ApplicationScope private val appScope: CoroutineScope
): ViewModel() {
    fun confirm() = viewModelScope.launch {
        taskDao.deleteCompleted()
    }
}