package com.kyle.tasksapp.ui.taskadd;

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
public final class TaskAddViewModel_AssistedFactory_Factory implements Factory<TaskAddViewModel_AssistedFactory> {
  private final Provider<TaskDao> taskDaoProvider;

  public TaskAddViewModel_AssistedFactory_Factory(Provider<TaskDao> taskDaoProvider) {
    this.taskDaoProvider = taskDaoProvider;
  }

  @Override
  public TaskAddViewModel_AssistedFactory get() {
    return newInstance(taskDaoProvider);
  }

  public static TaskAddViewModel_AssistedFactory_Factory create(Provider<TaskDao> taskDaoProvider) {
    return new TaskAddViewModel_AssistedFactory_Factory(taskDaoProvider);
  }

  public static TaskAddViewModel_AssistedFactory newInstance(Provider<TaskDao> taskDao) {
    return new TaskAddViewModel_AssistedFactory(taskDao);
  }
}
