package com.kyle.tasksapp.ui.taskadd

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.kyle.tasksapp.data.Task
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.String
import kotlin.Suppress
import kotlin.jvm.JvmStatic

data class TaskAddFragmentArgs(
  val task: Task? = null,
  val title: String
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(Task::class.java)) {
      result.putParcelable("task", this.task as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(Task::class.java)) {
      result.putSerializable("task", this.task as Serializable?)
    }
    result.putString("title", this.title)
    return result
  }

  companion object {
    @JvmStatic
    fun fromBundle(bundle: Bundle): TaskAddFragmentArgs {
      bundle.setClassLoader(TaskAddFragmentArgs::class.java.classLoader)
      val __task : Task?
      if (bundle.containsKey("task")) {
        if (Parcelable::class.java.isAssignableFrom(Task::class.java) ||
            Serializable::class.java.isAssignableFrom(Task::class.java)) {
          __task = bundle.get("task") as Task?
        } else {
          throw UnsupportedOperationException(Task::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        __task = null
      }
      val __title : String?
      if (bundle.containsKey("title")) {
        __title = bundle.getString("title")
        if (__title == null) {
          throw IllegalArgumentException("Argument \"title\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"title\" is missing and does not have an android:defaultValue")
      }
      return TaskAddFragmentArgs(__task, __title)
    }
  }
}
