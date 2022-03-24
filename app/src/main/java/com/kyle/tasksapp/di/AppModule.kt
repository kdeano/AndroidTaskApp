package com.kyle.tasksapp.di

import android.app.Application
import androidx.room.Room
import com.kyle.tasksapp.data.TaskDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

// Using object makes the Dagger implementation more efficient
@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    // Method for building the database with Room
    // Only creates one instance (singleton) throughout whole app (ApplicationComponent::class)
    @Provides
    @Singleton
    fun provideDatabase(
        app: Application,
        callback: TaskDatabase.Callback
    ) = Room.databaseBuilder(app, TaskDatabase::class.java, "task_database")
        // Tells Room to drop the table and create a new one when updating the database
        .fallbackToDestructiveMigration()
        .addCallback(callback)
        .build()

    // Creates the DAO with the queries listed in taskDao
    @Provides
    fun provideTaskDao(db: TaskDatabase) = db.taskDao()

    @ApplicationScope
    @Provides
    @Singleton
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())
}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope