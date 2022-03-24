package com.kyle.tasksapp.data;

import android.content.Context;
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
public final class PreferencesRepo_Factory implements Factory<PreferencesRepo> {
  private final Provider<Context> contextProvider;

  public PreferencesRepo_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public PreferencesRepo get() {
    return newInstance(contextProvider.get());
  }

  public static PreferencesRepo_Factory create(Provider<Context> contextProvider) {
    return new PreferencesRepo_Factory(contextProvider);
  }

  public static PreferencesRepo newInstance(Context context) {
    return new PreferencesRepo(context);
  }
}
