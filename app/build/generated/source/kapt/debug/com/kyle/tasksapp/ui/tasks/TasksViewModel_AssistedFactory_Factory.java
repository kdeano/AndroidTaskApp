package com.kyle.tasksapp.ui.tasks;

import com.kyle.tasksapp.data.PreferencesRepo;
import com.kyle.tasksapp.data.TaskDao;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class TasksViewModel_AssistedFactory_Factory implements Factory<TasksViewModel_AssistedFactory> {
  private final Provider<TaskDao> taskDaoProvider;

  private final Provider<PreferencesRepo> preferencesRepoProvider;

  public TasksViewModel_AssistedFactory_Factory(Provider<TaskDao> taskDaoProvider,
      Provider<PreferencesRepo> preferencesRepoProvider) {
    this.taskDaoProvider = taskDaoProvider;
    this.preferencesRepoProvider = preferencesRepoProvider;
  }

  @Override
  public TasksViewModel_AssistedFactory get() {
    return newInstance(taskDaoProvider, preferencesRepoProvider);
  }

  public static TasksViewModel_AssistedFactory_Factory create(Provider<TaskDao> taskDaoProvider,
      Provider<PreferencesRepo> preferencesRepoProvider) {
    return new TasksViewModel_AssistedFactory_Factory(taskDaoProvider, preferencesRepoProvider);
  }

  public static TasksViewModel_AssistedFactory newInstance(Provider<TaskDao> taskDao,
      Provider<PreferencesRepo> preferencesRepo) {
    return new TasksViewModel_AssistedFactory(taskDao, preferencesRepo);
  }
}
