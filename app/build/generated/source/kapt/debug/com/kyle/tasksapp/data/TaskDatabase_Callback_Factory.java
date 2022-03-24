package com.kyle.tasksapp.data;

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
public final class TaskDatabase_Callback_Factory implements Factory<TaskDatabase.Callback> {
  private final Provider<TaskDatabase> dataProvider;

  private final Provider<CoroutineScope> applicationScopeProvider;

  public TaskDatabase_Callback_Factory(Provider<TaskDatabase> dataProvider,
      Provider<CoroutineScope> applicationScopeProvider) {
    this.dataProvider = dataProvider;
    this.applicationScopeProvider = applicationScopeProvider;
  }

  @Override
  public TaskDatabase.Callback get() {
    return newInstance(dataProvider, applicationScopeProvider.get());
  }

  public static TaskDatabase_Callback_Factory create(Provider<TaskDatabase> dataProvider,
      Provider<CoroutineScope> applicationScopeProvider) {
    return new TaskDatabase_Callback_Factory(dataProvider, applicationScopeProvider);
  }

  public static TaskDatabase.Callback newInstance(Provider<TaskDatabase> data,
      CoroutineScope applicationScope) {
    return new TaskDatabase.Callback(data, applicationScope);
  }
}
