package com.kyle.tasksapp.di;

import com.kyle.tasksapp.data.TaskDao;
import com.kyle.tasksapp.data.TaskDatabase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class AppModule_ProvideTaskDaoFactory implements Factory<TaskDao> {
  private final Provider<TaskDatabase> dbProvider;

  public AppModule_ProvideTaskDaoFactory(Provider<TaskDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public TaskDao get() {
    return provideTaskDao(dbProvider.get());
  }

  public static AppModule_ProvideTaskDaoFactory create(Provider<TaskDatabase> dbProvider) {
    return new AppModule_ProvideTaskDaoFactory(dbProvider);
  }

  public static TaskDao provideTaskDao(TaskDatabase db) {
    return Preconditions.checkNotNull(AppModule.INSTANCE.provideTaskDao(db), "Cannot return null from a non-@Nullable @Provides method");
  }
}
