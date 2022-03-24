package com.kyle.tasksapp.ui.tasks;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.NavDirections;
import com.kyle.tasksapp.NavGraphDirections;
import com.kyle.tasksapp.R;
import com.kyle.tasksapp.data.Task;
import java.io.Serializable;
import kotlin.Int;
import kotlin.String;
import kotlin.Suppress;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0005"}, d2 = {"Lcom/kyle/tasksapp/ui/tasks/TasksFragmentDirections;", "", "()V", "ActionTasksFragmentToTaskAddFragment", "Companion", "app_debug"})
public final class TasksFragmentDirections {
    public static final com.kyle.tasksapp.ui.tasks.TasksFragmentDirections.Companion Companion = null;
    
    private TasksFragmentDirections() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0018"}, d2 = {"Lcom/kyle/tasksapp/ui/tasks/TasksFragmentDirections$ActionTasksFragmentToTaskAddFragment;", "Landroidx/navigation/NavDirections;", "task", "Lcom/kyle/tasksapp/data/Task;", "title", "", "(Lcom/kyle/tasksapp/data/Task;Ljava/lang/String;)V", "getTask", "()Lcom/kyle/tasksapp/data/Task;", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "getActionId", "", "getArguments", "Landroid/os/Bundle;", "hashCode", "toString", "app_debug"})
    static final class ActionTasksFragmentToTaskAddFragment implements androidx.navigation.NavDirections {
        @org.jetbrains.annotations.Nullable()
        private final com.kyle.tasksapp.data.Task task = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String title = null;
        
        @java.lang.Override()
        public int getActionId() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.Suppress(names = {"CAST_NEVER_SUCCEEDS"})
        @java.lang.Override()
        public android.os.Bundle getArguments() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.kyle.tasksapp.data.Task getTask() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTitle() {
            return null;
        }
        
        public ActionTasksFragmentToTaskAddFragment(@org.jetbrains.annotations.Nullable()
        com.kyle.tasksapp.data.Task task, @org.jetbrains.annotations.NotNull()
        java.lang.String title) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.kyle.tasksapp.data.Task component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.kyle.tasksapp.ui.tasks.TasksFragmentDirections.ActionTasksFragmentToTaskAddFragment copy(@org.jetbrains.annotations.Nullable()
        com.kyle.tasksapp.data.Task task, @org.jetbrains.annotations.NotNull()
        java.lang.String title) {
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
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u001a\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t\u00a8\u0006\n"}, d2 = {"Lcom/kyle/tasksapp/ui/tasks/TasksFragmentDirections$Companion;", "", "()V", "actionGlobalDeleteCompletedFragment", "Landroidx/navigation/NavDirections;", "actionTasksFragmentToTaskAddFragment", "task", "Lcom/kyle/tasksapp/data/Task;", "title", "", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.navigation.NavDirections actionTasksFragmentToTaskAddFragment(@org.jetbrains.annotations.Nullable()
        com.kyle.tasksapp.data.Task task, @org.jetbrains.annotations.NotNull()
        java.lang.String title) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.navigation.NavDirections actionGlobalDeleteCompletedFragment() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}