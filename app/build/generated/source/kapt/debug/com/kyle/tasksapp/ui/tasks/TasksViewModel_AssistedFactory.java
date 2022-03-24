package com.kyle.tasksapp.ui.tasks;

import androidx.annotation.NonNull;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.SavedStateHandle;
import com.kyle.tasksapp.data.PreferencesRepo;
import com.kyle.tasksapp.data.TaskDao;
import java.lang.Override;
import javax.annotation.Generated;
import javax.inject.Inject;
import javax.inject.Provider;

@Generated("androidx.hilt.AndroidXHiltProcessor")
public final class TasksViewModel_AssistedFactory implements ViewModelAssistedFactory<TasksViewModel> {
  private final Provider<TaskDao> taskDao;

  private final Provider<PreferencesRepo> preferencesRepo;

  @Inject
  TasksViewModel_AssistedFactory(Provider<TaskDao> taskDao,
      Provider<PreferencesRepo> preferencesRepo) {
    this.taskDao = taskDao;
    this.preferencesRepo = preferencesRepo;
  }

  @Override
  @NonNull
  public TasksViewModel create(SavedStateHandle arg0) {
    return new TasksViewModel(taskDao.get(), preferencesRepo.get(), arg0);
  }
}
