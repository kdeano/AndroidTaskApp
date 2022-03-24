package com.kyle.tasksapp.ui.taskadd

import androidx.navigation.NavDirections
import com.kyle.tasksapp.NavGraphDirections

class TaskAddFragmentDirections private constructor() {
  companion object {
    fun actionGlobalDeleteCompletedFragment(): NavDirections =
        NavGraphDirections.actionGlobalDeleteCompletedFragment()
  }
}
