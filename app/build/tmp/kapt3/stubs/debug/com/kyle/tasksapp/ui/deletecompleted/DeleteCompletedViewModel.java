package com.kyle.tasksapp.ui.deletecompleted;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.ViewModel;
import com.kyle.tasksapp.data.TaskDao;
import com.kyle.tasksapp.di.ApplicationScope;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/kyle/tasksapp/ui/deletecompleted/DeleteCompletedViewModel;", "Landroidx/lifecycle/ViewModel;", "taskDao", "Lcom/kyle/tasksapp/data/TaskDao;", "appScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lcom/kyle/tasksapp/data/TaskDao;Lkotlinx/coroutines/CoroutineScope;)V", "confirm", "Lkotlinx/coroutines/Job;", "app_debug"})
public final class DeleteCompletedViewModel extends androidx.lifecycle.ViewModel {
    private final com.kyle.tasksapp.data.TaskDao taskDao = null;
    private final kotlinx.coroutines.CoroutineScope appScope = null;
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job confirm() {
        return null;
    }
    
    @androidx.hilt.lifecycle.ViewModelInject()
    public DeleteCompletedViewModel(@org.jetbrains.annotations.NotNull()
    com.kyle.tasksapp.data.TaskDao taskDao, @org.jetbrains.annotations.NotNull()
    @com.kyle.tasksapp.di.ApplicationScope()
    kotlinx.coroutines.CoroutineScope appScope) {
        super();
    }
}