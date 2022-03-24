package com.kyle.tasksapp

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

class NavGraphDirections private constructor() {
  companion object {
    fun actionGlobalDeleteCompletedFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_global_deleteCompletedFragment)
  }
}
