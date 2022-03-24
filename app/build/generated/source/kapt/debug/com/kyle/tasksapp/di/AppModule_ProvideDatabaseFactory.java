package com.kyle.tasksapp.di;

import android.app.Application;
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
public final class AppModule_ProvideDatabaseFactory implements Factory<TaskDatabase> {
  private final Provider<Application> appProvider;

  private final Provider<TaskDatabase.Callback> callbackProvider;

  public AppModule_ProvideDatabaseFactory(Provider<Application> appProvider,
      Provider<TaskDatabase.Callback> callbackProvider) {
    this.appProvider = appProvider;
    this.callbackProvider = callbackProvider;
  }

  @Override
  public TaskDatabase get() {
    return provideDatabase(appProvider.get(), callbackProvider.get());
  }

  public static AppModule_ProvideDatabaseFactory create(Provider<Application> appProvider,
      Provider<TaskDatabase.Callback> callbackProvider) {
    return new AppModule_ProvideDatabaseFactory(appProvider, callbackProvider);
  }

  public static TaskDatabase provideDatabase(Application app, TaskDatabase.Callback callback) {
    return Preconditions.checkNotNull(AppModule.INSTANCE.provideDatabase(app, callback), "Cannot return null from a non-@Nullable @Provides method");
  }
}
