package com.kyle.tasksapp.data

import android.content.Context
import android.util.Log
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.emptyPreferences
import androidx.datastore.preferences.preferencesKey
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

// Abstracts all of this data from the outside so viewmodel has data prepared for it

private const val TAG = "PreferencesRepo"

// Creates two objects for SortOrder values
enum class SortOrder {
    BY_NAME,
    BY_DATE
}

data class FilterPreferences(val sortOrder: SortOrder, val hideCompleted: Boolean)

// Only ever need one instance of this class
@Singleton
class PreferencesRepo @Inject constructor(@ApplicationContext context: Context) {
    // Using Jetpack DataStore to save key-value pairs asynchronously (fast)
    private val dataStore = context.createDataStore("user_preferences")
    // Try-catch method, maps keys on success
    val preferencesFlow = dataStore.data
        .catch { exception ->
            if(exception is IOException) {
                Log.e(TAG, "Error: reading preferences", exception)
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            val sortOrder = SortOrder.valueOf(
            preferences[PreferencesKeys.SORT_ORDER] ?: SortOrder.BY_DATE.name
        )
        val hideCompleted = preferences[PreferencesKeys.HIDE_COMPLETED] ?: false
        FilterPreferences(sortOrder, hideCompleted)
    }

    // Saves state of sort order
    suspend fun updateSortOrder(sortOrder: SortOrder) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.SORT_ORDER] = sortOrder.name
        }
    }

    // Saves state of hide completed check
    suspend fun updateHideCompleted(hideCompleted: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.HIDE_COMPLETED] = hideCompleted
        }
    }

    // Distinguish between the keys created in this class
    // Can be referenced in the data store
    private object PreferencesKeys {
        val SORT_ORDER = preferencesKey<String>("sort_order")
        val HIDE_COMPLETED = preferencesKey<Boolean>("hide_completed")
    }
}