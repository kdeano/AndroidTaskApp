package com.kyle.tasksapp.ui.taskadd;

import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.kyle.tasksapp.data.Task;
import com.kyle.tasksapp.data.TaskDao;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001&B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u0012H\u0002J\u0010\u0010%\u001a\u00020 2\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u0012@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\'"}, d2 = {"Lcom/kyle/tasksapp/ui/taskadd/TaskAddViewModel;", "Landroidx/lifecycle/ViewModel;", "taskDao", "Lcom/kyle/tasksapp/data/TaskDao;", "state", "Landroidx/lifecycle/SavedStateHandle;", "(Lcom/kyle/tasksapp/data/TaskDao;Landroidx/lifecycle/SavedStateHandle;)V", "task", "Lcom/kyle/tasksapp/data/Task;", "getTask", "()Lcom/kyle/tasksapp/data/Task;", "value", "", "taskImportance", "getTaskImportance", "()Z", "setTaskImportance", "(Z)V", "", "taskName", "getTaskName", "()Ljava/lang/String;", "setTaskName", "(Ljava/lang/String;)V", "taskUpdateChannel", "Lkotlinx/coroutines/channels/Channel;", "Lcom/kyle/tasksapp/ui/taskadd/TaskAddViewModel$TaskUpdateEvent;", "taskUpdateEvent", "Lkotlinx/coroutines/flow/Flow;", "getTaskUpdateEvent", "()Lkotlinx/coroutines/flow/Flow;", "createTask", "Lkotlinx/coroutines/Job;", "saveClick", "", "showInvalidInputMsg", "text", "updateTask", "TaskUpdateEvent", "app_debug"})
public final class TaskAddViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.Nullable()
    private final com.kyle.tasksapp.data.Task task = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String taskName;
    private boolean taskImportance;
    private final kotlinx.coroutines.channels.Channel<com.kyle.tasksapp.ui.taskadd.TaskAddViewModel.TaskUpdateEvent> taskUpdateChannel = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.kyle.tasksapp.ui.taskadd.TaskAddViewModel.TaskUpdateEvent> taskUpdateEvent = null;
    private final com.kyle.tasksapp.data.TaskDao taskDao = null;
    private final androidx.lifecycle.SavedStateHandle state = null;
    
    @org.jetbrains.annotations.Nullable()
    public final com.kyle.tasksapp.data.Task getTask() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTaskName() {
        return null;
    }
    
    public final void setTaskName(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final boolean getTaskImportance() {
        return false;
    }
    
    public final void setTaskImportance(boolean value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.kyle.tasksapp.ui.taskadd.TaskAddViewModel.TaskUpdateEvent> getTaskUpdateEvent() {
        return null;
    }
    
    public final void saveClick() {
    }
    
    private final kotlinx.coroutines.Job showInvalidInputMsg(java.lang.String text) {
        return null;
    }
    
    private final kotlinx.coroutines.Job createTask(com.kyle.tasksapp.data.Task task) {
        return null;
    }
    
    private final kotlinx.coroutines.Job updateTask(com.kyle.tasksapp.data.Task task) {
        return null;
    }
    
    @androidx.hilt.lifecycle.ViewModelInject()
    public TaskAddViewModel(@org.jetbrains.annotations.NotNull()
    com.kyle.tasksapp.data.TaskDao taskDao, @org.jetbrains.annotations.NotNull()
    @androidx.hilt.Assisted()
    androidx.lifecycle.SavedStateHandle state) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/kyle/tasksapp/ui/taskadd/TaskAddViewModel$TaskUpdateEvent;", "", "()V", "GoBack", "ShowInvalidInputMsg", "Lcom/kyle/tasksapp/ui/taskadd/TaskAddViewModel$TaskUpdateEvent$ShowInvalidInputMsg;", "Lcom/kyle/tasksapp/ui/taskadd/TaskAddViewModel$TaskUpdateEvent$GoBack;", "app_debug"})
    public static abstract class TaskUpdateEvent {
        
        private TaskUpdateEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/kyle/tasksapp/ui/taskadd/TaskAddViewModel$TaskUpdateEvent$ShowInvalidInputMsg;", "Lcom/kyle/tasksapp/ui/taskadd/TaskAddViewModel$TaskUpdateEvent;", "msg", "", "(Ljava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class ShowInvalidInputMsg extends com.kyle.tasksapp.ui.taskadd.TaskAddViewModel.TaskUpdateEvent {
            @org.jetbrains.annotations.NotNull()
            private final java.lang.String msg = null;
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getMsg() {
                return null;
            }
            
            public ShowInvalidInputMsg(@org.jetbrains.annotations.NotNull()
            java.lang.String msg) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.kyle.tasksapp.ui.taskadd.TaskAddViewModel.TaskUpdateEvent.ShowInvalidInputMsg copy(@org.jetbrains.annotations.NotNull()
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
        
        @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/kyle/tasksapp/ui/taskadd/TaskAddViewModel$TaskUpdateEvent$GoBack;", "Lcom/kyle/tasksapp/ui/taskadd/TaskAddViewModel$TaskUpdateEvent;", "result", "", "(I)V", "getResult", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_debug"})
        public static final class GoBack extends com.kyle.tasksapp.ui.taskadd.TaskAddViewModel.TaskUpdateEvent {
            private final int result = 0;
            
            public final int getResult() {
                return 0;
            }
            
            public GoBack(int result) {
                super();
            }
            
            public final int component1() {
                return 0;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.kyle.tasksapp.ui.taskadd.TaskAddViewModel.TaskUpdateEvent.GoBack copy(int result) {
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