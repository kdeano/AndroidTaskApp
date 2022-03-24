package com.kyle.tasksapp.ui.deletecompleted;

import com.kyle.tasksapp.data.TaskDao;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineScope;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DeleteCompletedViewModel_AssistedFactory_Factory implements Factory<DeleteCompletedViewModel_AssistedFactory> {
  private final Provider<TaskDao> taskDaoProvider;

  private final Provider<CoroutineScope> appScopeProvider;

  public DeleteCompletedViewModel_AssistedFactory_Factory(Provider<TaskDao> taskDaoProvider,
      Provider<CoroutineScope> appScopeProvider) {
    this.taskDaoProvider = taskDaoProvider;
    this.appScopeProvider = appScopeProvider;
  }

  @Override
  public DeleteCompletedViewModel_AssistedFactory get() {
    return newInstance(taskDaoProvider, appScopeProvider);
  }

  public static DeleteCompletedViewModel_AssistedFactory_Factory create(
      Provider<TaskDao> taskDaoProvider, Provider<CoroutineScope> appScopeProvider) {
    return new DeleteCompletedViewModel_AssistedFactory_Factory(taskDaoProvider, appScopeProvider);
  }

  public static DeleteCompletedViewModel_AssistedFactory newInstance(Provider<TaskDao> taskDao,
      Provider<CoroutineScope> appScope) {
    return new DeleteCompletedViewModel_AssistedFactory(taskDao, appScope);
  }
}
