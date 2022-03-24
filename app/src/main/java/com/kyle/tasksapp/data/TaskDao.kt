package com.kyle.tasksapp.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

// Data Access Object
// Provides an interface to the TaskDatabase
// All database queries go in this file
@Dao
interface TaskDao {
    fun getTasks(query: String, sortOrder: SortOrder, hideCompleted: Boolean): Flow<List<Task>> =
        when(sortOrder) {
            SortOrder.BY_DATE -> getTasksByDate(query, hideCompleted)
            SortOrder.BY_NAME -> getTasksByName(query, hideCompleted)
        }

    @Query("SELECT * FROM table_task WHERE (completed != :hideCompleted OR completed = 0) AND task LIKE '%' || :searchQuery || '%' ORDER BY important DESC, task")
    fun getTasksByName(searchQuery: String, hideCompleted: Boolean): Flow<List<Task>>

    @Query("SELECT * FROM table_task WHERE (completed != :hideCompleted OR completed = 0) AND task LIKE '%' || :searchQuery || '%' ORDER BY important DESC, timestamp")
    fun getTasksByDate(searchQuery: String, hideCompleted: Boolean): Flow<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: Task)

    @Update
    suspend fun update(task: Task)

    @Delete
    suspend fun delete(task: Task)

    @Query("DELETE FROM table_task WHERE completed = 1")
    suspend fun deleteCompleted()
}