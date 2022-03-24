package com.kyle.tasksapp.ui.deletecompleted

import androidx.navigation.NavDirections
import com.kyle.tasksapp.NavGraphDirections

class DeleteCompletedFragmentDirections private constructor() {
  companion object {
    fun actionGlobalDeleteCompletedFragment(): NavDirections =
        NavGraphDirections.actionGlobalDeleteCompletedFragment()
  }
}
