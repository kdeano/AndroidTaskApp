package com.kyle.tasksapp.di;

import android.app.Application;
import androidx.room.Room;
import com.kyle.tasksapp.data.TaskDatabase;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import javax.inject.Qualifier;
import javax.inject.Singleton;

@dagger.hilt.InstallIn(value = {dagger.hilt.android.components.ApplicationComponent.class})
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/kyle/tasksapp/di/AppModule;", "", "()V", "provideApplicationScope", "Lkotlinx/coroutines/CoroutineScope;", "provideDatabase", "Lcom/kyle/tasksapp/data/TaskDatabase;", "app", "Landroid/app/Application;", "callback", "Lcom/kyle/tasksapp/data/TaskDatabase$Callback;", "provideTaskDao", "Lcom/kyle/tasksapp/data/TaskDao;", "db", "app_debug"})
@dagger.Module()
public final class AppModule {
    public static final com.kyle.tasksapp.di.AppModule INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kyle.tasksapp.data.TaskDatabase provideDatabase(@org.jetbrains.annotations.NotNull()
    android.app.Application app, @org.jetbrains.annotations.NotNull()
    com.kyle.tasksapp.data.TaskDatabase.Callback callback) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.kyle.tasksapp.data.TaskDao provideTaskDao(@org.jetbrains.annotations.NotNull()
    com.kyle.tasksapp.data.TaskDatabase db) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    @ApplicationScope()
    public final kotlinx.coroutines.CoroutineScope provideApplicationScope() {
        return null;
    }
    
    private AppModule() {
        super();
    }
}