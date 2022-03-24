package com.kyle.tasksapp.ui.taskadd;

import androidx.annotation.NonNull;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.SavedStateHandle;
import com.kyle.tasksapp.data.TaskDao;
import java.lang.Override;
import javax.annotation.Generated;
import javax.inject.Inject;
import javax.inject.Provider;

@Generated("androidx.hilt.AndroidXHiltProcessor")
public final class TaskAddViewModel_AssistedFactory implements ViewModelAssistedFactory<TaskAddViewModel> {
  private final Provider<TaskDao> taskDao;

  @Inject
  TaskAddViewModel_AssistedFactory(Provider<TaskDao> taskDao) {
    this.taskDao = taskDao;
  }

  @Override
  @NonNull
  public TaskAddViewModel create(SavedStateHandle arg0) {
    return new TaskAddViewModel(taskDao.get(), arg0);
  }
}
