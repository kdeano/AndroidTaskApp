package com.kyle.tasksapp.ui.deletecompleted;

import androidx.annotation.NonNull;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.SavedStateHandle;
import com.kyle.tasksapp.data.TaskDao;
import com.kyle.tasksapp.di.ApplicationScope;
import java.lang.Override;
import javax.annotation.Generated;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineScope;

@Generated("androidx.hilt.AndroidXHiltProcessor")
public final class DeleteCompletedViewModel_AssistedFactory implements ViewModelAssistedFactory<DeleteCompletedViewModel> {
  private final Provider<TaskDao> taskDao;

  private final Provider<CoroutineScope> appScope;

  @Inject
  DeleteCompletedViewModel_AssistedFactory(Provider<TaskDao> taskDao,
      @ApplicationScope Provider<CoroutineScope> appScope) {
    this.taskDao = taskDao;
    this.appScope = appScope;
  }

  @Override
  @NonNull
  public DeleteCompletedViewModel create(SavedStateHandle arg0) {
    return new DeleteCompletedViewModel(taskDao.get(), appScope.get());
  }
}
