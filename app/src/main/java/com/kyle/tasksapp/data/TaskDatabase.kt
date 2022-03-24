package com.kyle.tasksapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.kyle.tasksapp.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

// TaskDatabase inherits from RoomDatabase
// Implements the DAO where queries are handled
@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao

    // Pre populates the Room database which is then overridden in the RoomDatabase builder
    class Callback @Inject constructor(
        private val data: Provider<TaskDatabase>,
        @ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback() {

        // First time running the app creates the database
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            val dao = data.get().taskDao()
        }
    }
}