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

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/kyle/tasksapp/di/ApplicationScope;", "", "app_debug"})
@java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
@javax.inject.Qualifier()
@kotlin.annotation.Retention(value = kotlin.annotation.AnnotationRetention.RUNTIME)
public abstract @interface ApplicationScope {
}