package com.kyle.tasksapp.ui.tasks

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.kyle.tasksapp.NavGraphDirections
import com.kyle.tasksapp.R
import com.kyle.tasksapp.data.Task
import java.io.Serializable
import kotlin.Int
import kotlin.String
import kotlin.Suppress

class TasksFragmentDirections private constructor() {
  private data class ActionTasksFragmentToTaskAddFragment(
    val task: Task? = null,
    val title: String
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_tasksFragment_to_taskAddFragment

    @Suppress("CAST_NEVER_SUCCEEDS")
    override fun getArguments(): Bundle {
      val result = Bundle()
      if (Parcelable::class.java.isAssignableFrom(Task::class.java)) {
        result.putParcelable("task", this.task as Parcelable?)
      } else if (Serializable::class.java.isAssignableFrom(Task::class.java)) {
        result.putSerializable("task", this.task as Serializable?)
      }
      result.putString("title", this.title)
      return result
    }
  }

  companion object {
    fun actionTasksFragmentToTaskAddFragment(task: Task? = null, title: String): NavDirections =
        ActionTasksFragmentToTaskAddFragment(task, title)

    fun actionGlobalDeleteCompletedFragment(): NavDirections =
        NavGraphDirections.actionGlobalDeleteCompletedFragment()
  }
}
