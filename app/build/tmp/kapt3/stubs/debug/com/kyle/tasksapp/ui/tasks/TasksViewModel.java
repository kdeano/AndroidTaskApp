package com.kyle.tasksapp.ui.tasks;

import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.*;
import com.kyle.tasksapp.data.PreferencesRepo;
import com.kyle.tasksapp.data.SortOrder;
import com.kyle.tasksapp.data.Task;
import com.kyle.tasksapp.data.TaskDao;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00015B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\u000e\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020!2\u0006\u0010\'\u001a\u00020(J\u0016\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020%J\u0010\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020\u0010H\u0002J\u000e\u0010.\u001a\u00020!2\u0006\u0010*\u001a\u00020\u0016J\u000e\u0010/\u001a\u00020!2\u0006\u0010*\u001a\u00020\u0016J\u000e\u00100\u001a\u00020!2\u0006\u0010*\u001a\u00020\u0016J\u000e\u00101\u001a\u0002022\u0006\u00103\u001a\u000204R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\rR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00066"}, d2 = {"Lcom/kyle/tasksapp/ui/tasks/TasksViewModel;", "Landroidx/lifecycle/ViewModel;", "taskDao", "Lcom/kyle/tasksapp/data/TaskDao;", "preferencesRepo", "Lcom/kyle/tasksapp/data/PreferencesRepo;", "state", "Landroidx/lifecycle/SavedStateHandle;", "(Lcom/kyle/tasksapp/data/TaskDao;Lcom/kyle/tasksapp/data/PreferencesRepo;Landroidx/lifecycle/SavedStateHandle;)V", "preferencesFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/kyle/tasksapp/data/FilterPreferences;", "getPreferencesFlow", "()Lkotlinx/coroutines/flow/Flow;", "searchQuery", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "getSearchQuery", "()Landroidx/lifecycle/MutableLiveData;", "taskFlow", "", "Lcom/kyle/tasksapp/data/Task;", "tasks", "Landroidx/lifecycle/LiveData;", "getTasks", "()Landroidx/lifecycle/LiveData;", "tasksEvent", "Lcom/kyle/tasksapp/ui/tasks/TasksViewModel$TasksEvent;", "getTasksEvent", "tasksEventChannel", "Lkotlinx/coroutines/channels/Channel;", "addNewTask", "Lkotlinx/coroutines/Job;", "deleteCompleted", "onHideCompleted", "hideCompleted", "", "onSortOrder", "sortOrder", "Lcom/kyle/tasksapp/data/SortOrder;", "taskChecked", "task", "isChecked", "taskSavedMsg", "text", "taskSelected", "taskSwiped", "undoDelete", "updateResult", "", "result", "", "TasksEvent", "app_debug"})
public final class TasksViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> searchQuery = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.kyle.tasksapp.data.FilterPreferences> preferencesFlow = null;
    private final kotlinx.coroutines.channels.Channel<com.kyle.tasksapp.ui.tasks.TasksViewModel.TasksEvent> tasksEventChannel = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.kyle.tasksapp.ui.tasks.TasksViewModel.TasksEvent> tasksEvent = null;
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.kyle.tasksapp.data.Task>> taskFlow = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.kyle.tasksapp.data.Task>> tasks = null;
    private final com.kyle.tasksapp.data.TaskDao taskDao = null;
    private final com.kyle.tasksapp.data.PreferencesRepo preferencesRepo = null;
    private final androidx.lifecycle.SavedStateHandle state = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getSearchQuery() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.kyle.tasksapp.data.FilterPreferences> getPreferencesFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.kyle.tasksapp.ui.tasks.TasksViewModel.TasksEvent> getTasksEvent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.kyle.tasksapp.data.Task>> getTasks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onSortOrder(@org.jetbrains.annotations.NotNull()
    com.kyle.tasksapp.data.SortOrder sortOrder) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onHideCompleted(boolean hideCompleted) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job taskSelected(@org.jetbrains.annotations.NotNull()
    com.kyle.tasksapp.data.Task task) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job taskChecked(@org.jetbrains.annotations.NotNull()
    com.kyle.tasksapp.data.Task task, boolean isChecked) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job undoDelete(@org.jetbrains.annotations.NotNull()
    com.kyle.tasksapp.data.Task task) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job addNewTask() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job deleteCompleted() {
        return null;
    }
    
    private final kotlinx.coroutines.Job taskSavedMsg(java.lang.String text) {
        return null;
    }
    
    public final void updateResult(int result) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job taskSwiped(@org.jetbrains.annotations.NotNull()
    com.kyle.tasksapp.data.Task task) {
        return null;
    }
    
    @androidx.hilt.lifecycle.ViewModelInject()
    public TasksViewModel(@org.jetbrains.annotations.NotNull()
    com.kyle.tasksapp.data.TaskDao taskDao, @org.jetbrains.annotations.NotNull()
    com.kyle.tasksapp.data.PreferencesRepo preferencesRepo, @org.jetbrains.annotations.NotNull()
    @androidx.hilt.Assisted()
    androidx.lifecycle.SavedStateHandle state) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f\u00a8\u0006\r"}, d2 = {"Lcom/kyle/tasksapp/ui/tasks/TasksViewModel$TasksEvent;", "", "()V", "GoToAddTask", "GoToDeleteCompleted", "GoToEditTask", "ShowUndoMsg", "TaskSavedMsg", "Lcom/kyle/tasksapp/ui/tasks/TasksViewModel$TasksEvent$GoToAddTask;", "Lcom/kyle/tasksapp/ui/tasks/TasksViewModel$TasksEvent$GoToDeleteCompleted;", "Lcom/kyle/tasksapp/ui/tasks/TasksViewModel$TasksEvent$GoToEditTask;", "Lcom/kyle/tasksapp/ui/tasks/TasksViewModel$TasksEvent$ShowUndoMsg;", "Lcom/kyle/tasksapp/ui/tasks/TasksViewModel$TasksEvent$TaskSavedMsg;", "app_debug"})
    public static abstract class TasksEvent {
        
        private TasksEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/kyle/tasksapp/ui/tasks/TasksViewModel$TasksEvent$GoToAddTask;", "Lcom/kyle/tasksapp/ui/tasks/TasksViewModel$TasksEvent;", "()V", "app_debug"})
        public static final class GoToAddTask extends com.kyle.tasksapp.ui.tasks.TasksViewModel.TasksEvent {
            public static final com.kyle.tasksapp.ui.tasks.TasksViewModel.TasksEvent.GoToAddTask INSTANCE = null;
            
            private GoToAddTask() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/kyle/tasksapp/ui/tasks/TasksViewModel$TasksEvent$GoToDeleteCompleted;", "Lcom/kyle/tasksapp/ui/tasks/TasksViewModel$TasksEvent;", "()V", "app_debug"})
        public static final class GoToDeleteCompleted extends com.kyle.tasksapp.ui.tasks.TasksViewModel.TasksEvent {
            public static final com.kyle.tasksapp.ui.tasks.TasksViewModel.TasksEvent.GoToDeleteCompleted INSTANCE = null;
            
            private GoToDeleteCompleted() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/kyle/tasksapp/ui/tasks/TasksViewModel$TasksEvent$GoToEditTask;", "Lcom/kyle/tasksapp/ui/tasks/TasksViewModel$TasksEvent;", "task", "Lcom/kyle/tasksapp/data/Task;", "(Lcom/kyle/tasksapp/data/Task;)V", "getTask", "()Lcom/kyle/tasksapp/data/Task;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class GoToEditTask extends com.kyle.tasksapp.ui.tasks.TasksViewModel.TasksEvent {
            @org.jetbrains.annotations.NotNull()
            private final com.kyle.tasksapp.data.Task task = null;
            
            @org.jetbrains.annotations.NotNull()
            public final com.kyle.tasksapp.data.Task getTask() {
                return null;
            }
            
            public GoToEditTask(@org.jetbrains.annotations.NotNull()
            com.kyle.tasksapp.data.Task task) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.kyle.tasksapp.data.Task component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.kyle.tasksapp.ui.tasks.TasksViewModel.TasksEvent.GoToEditTask copy(@org.jetbrains.annotations.NotNull()
            com.kyle.tasksapp.data.Task task) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public java.lang.String toString() {
                return null;
            }
            
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object p0) {
                return false;
            }
        }
        
        @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/kyle/tasksapp/ui/tasks/TasksViewModel$TasksEvent$ShowUndoMsg;", "Lcom/kyle/tasksapp/ui/tasks/TasksViewModel$TasksEvent;", "task", "Lcom/kyle/tasksapp/data/Task;", "(Lcom/kyle/tasksapp/data/Task;)V", "getTask", "()Lcom/kyle/tasksapp/data/Task;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class ShowUndoMsg extends com.kyle.tasksapp.ui.tasks.TasksViewModel.TasksEvent {
            @org.jetbrains.annotations.NotNull()
            private final com.kyle.tasksapp.data.Task task = null;
            
            @org.jetbrains.annotations.NotNull()
            public final com.kyle.tasksapp.data.Task getTask() {
                return null;
            }
            
            public ShowUndoMsg(@org.jetbrains.annotations.NotNull()
            com.kyle.tasksapp.data.Task task) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.kyle.tasksapp.data.Task component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.kyle.tasksapp.ui.tasks.TasksViewModel.TasksEvent.ShowUndoMsg copy(@org.jetbrains.annotations.NotNull()
            com.kyle.tasksapp.data.Task task) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public java.lang.String toString() {
                return null;
            }
            
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object p0) {
                return false;
            }
        }
        
        @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/kyle/tasksapp/ui/tasks/TasksViewModel$TasksEvent$TaskSavedMsg;", "Lcom/kyle/tasksapp/ui/tasks/TasksViewModel$TasksEvent;", "msg", "", "(Ljava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class TaskSavedMsg extends com.kyle.tasksapp.ui.tasks.TasksViewModel.TasksEvent {
            @org.jetbrains.annotations.NotNull()
            private final java.lang.String msg = null;
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getMsg() {
                return null;
            }
            
            public TaskSavedMsg(@org.jetbrains.annotations.NotNull()
            java.lang.String msg) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.kyle.tasksapp.ui.tasks.TasksViewModel.TasksEvent.TaskSavedMsg copy(@org.jetbrains.annotations.NotNull()
            java.lang.String msg) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public java.lang.String toString() {
                return null;
            }
            
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object p0) {
                return false;
            }
        }
    }
}