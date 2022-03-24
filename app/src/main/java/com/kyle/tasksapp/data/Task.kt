package com.kyle.tasksapp.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.text.DateFormat

// Creates database values in immutable state so values cannot be changed outside of class
@Entity(tableName = "table_task")
@Parcelize
data class Task(
    val task: String,
    val important: Boolean = false,
    val completed: Boolean = false,
    val timestamp: Long = System.currentTimeMillis(),
    @PrimaryKey(autoGenerate = true) val id: Int = 0
) : Parcelable {
    val timestampFormatted: String
        get() = DateFormat.getDateTimeInstance().format(timestamp)
}