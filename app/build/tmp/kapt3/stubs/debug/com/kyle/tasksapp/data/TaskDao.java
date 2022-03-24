package com.kyle.tasksapp.data;

import androidx.room.*;
import kotlinx.coroutines.flow.Flow;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ,\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J$\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\n2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\'J$\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\n2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\'J\u0019\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lcom/kyle/tasksapp/data/TaskDao;", "", "delete", "", "task", "Lcom/kyle/tasksapp/data/Task;", "(Lcom/kyle/tasksapp/data/Task;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCompleted", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTasks", "Lkotlinx/coroutines/flow/Flow;", "", "query", "", "sortOrder", "Lcom/kyle/tasksapp/data/SortOrder;", "hideCompleted", "", "getTasksByDate", "searchQuery", "getTasksByName", "insert", "update", "app_debug"})
public abstract interface TaskDao {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.kyle.tasksapp.data.Task>> getTasks(@org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    com.kyle.tasksapp.data.SortOrder sortOrder, boolean hideCompleted);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM table_task WHERE (completed != :hideCompleted OR completed = 0) AND task LIKE \'%\' || :searchQuery || \'%\' ORDER BY important DESC, task")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.kyle.tasksapp.data.Task>> getTasksByName(@org.jetbrains.annotations.NotNull()
    java.lang.String searchQuery, boolean hideCompleted);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM table_task WHERE (completed != :hideCompleted OR completed = 0) AND task LIKE \'%\' || :searchQuery || \'%\' ORDER BY important DESC, timestamp")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.kyle.tasksapp.data.Task>> getTasksByDate(@org.jetbrains.annotations.NotNull()
    java.lang.String searchQuery, boolean hideCompleted);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.kyle.tasksapp.data.Task task, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Update()
    public abstract java.lang.Object update(@org.jetbrains.annotations.NotNull()
    com.kyle.tasksapp.data.Task task, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Delete()
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.kyle.tasksapp.data.Task task, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "DELETE FROM table_task WHERE completed = 1")
    public abstract java.lang.Object deleteCompleted(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p0);
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        @org.jetbrains.annotations.NotNull()
        public static kotlinx.coroutines.flow.Flow<java.util.List<com.kyle.tasksapp.data.Task>> getTasks(@org.jetbrains.annotations.NotNull()
        com.kyle.tasksapp.data.TaskDao $this, @org.jetbrains.annotations.NotNull()
        java.lang.String query, @org.jetbrains.annotations.NotNull()
        com.kyle.tasksapp.data.SortOrder sortOrder, boolean hideCompleted) {
            return null;
        }
    }
}