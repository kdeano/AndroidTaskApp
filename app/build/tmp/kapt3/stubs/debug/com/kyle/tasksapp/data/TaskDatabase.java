package com.kyle.tasksapp.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.kyle.tasksapp.di.ApplicationScope;
import javax.inject.Inject;
import javax.inject.Provider;

@androidx.room.Database(entities = {com.kyle.tasksapp.data.Task.class}, version = 1)
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u00002\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/kyle/tasksapp/data/TaskDatabase;", "Landroidx/room/RoomDatabase;", "()V", "taskDao", "Lcom/kyle/tasksapp/data/TaskDao;", "Callback", "app_debug"})
public abstract class TaskDatabase extends androidx.room.RoomDatabase {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.kyle.tasksapp.data.TaskDao taskDao();
    
    public TaskDatabase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/kyle/tasksapp/data/TaskDatabase$Callback;", "Landroidx/room/RoomDatabase$Callback;", "data", "Ljavax/inject/Provider;", "Lcom/kyle/tasksapp/data/TaskDatabase;", "applicationScope", "Lkotlinx/coroutines/CoroutineScope;", "(Ljavax/inject/Provider;Lkotlinx/coroutines/CoroutineScope;)V", "onCreate", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "app_debug"})
    public static final class Callback extends androidx.room.RoomDatabase.Callback {
        private final javax.inject.Provider<com.kyle.tasksapp.data.TaskDatabase> data = null;
        private final kotlinx.coroutines.CoroutineScope applicationScope = null;
        
        @java.lang.Override()
        public void onCreate(@org.jetbrains.annotations.NotNull()
        androidx.sqlite.db.SupportSQLiteDatabase db) {
        }
        
        @javax.inject.Inject()
        public Callback(@org.jetbrains.annotations.NotNull()
        javax.inject.Provider<com.kyle.tasksapp.data.TaskDatabase> data, @org.jetbrains.annotations.NotNull()
        @com.kyle.tasksapp.di.ApplicationScope()
        kotlinx.coroutines.CoroutineScope applicationScope) {
            super();
        }
    }
}