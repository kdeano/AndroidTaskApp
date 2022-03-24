package com.kyle.tasksapp;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.hilt.lifecycle.ViewModelFactoryModules_ActivityModule_ProvideFactoryFactory;
import androidx.hilt.lifecycle.ViewModelFactoryModules_FragmentModule_ProvideFactoryFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.kyle.tasksapp.data.PreferencesRepo;
import com.kyle.tasksapp.data.TaskDao;
import com.kyle.tasksapp.data.TaskDatabase;
import com.kyle.tasksapp.di.AppModule;
import com.kyle.tasksapp.di.AppModule_ProvideApplicationScopeFactory;
import com.kyle.tasksapp.di.AppModule_ProvideDatabaseFactory;
import com.kyle.tasksapp.di.AppModule_ProvideTaskDaoFactory;
import com.kyle.tasksapp.ui.MainActivity;
import com.kyle.tasksapp.ui.deletecompleted.DeleteCompletedFragment;
import com.kyle.tasksapp.ui.deletecompleted.DeleteCompletedViewModel_AssistedFactory;
import com.kyle.tasksapp.ui.deletecompleted.DeleteCompletedViewModel_AssistedFactory_Factory;
import com.kyle.tasksapp.ui.taskadd.TaskAddFragment;
import com.kyle.tasksapp.ui.taskadd.TaskAddViewModel_AssistedFactory;
import com.kyle.tasksapp.ui.taskadd.TaskAddViewModel_AssistedFactory_Factory;
import com.kyle.tasksapp.ui.tasks.TasksFragment;
import com.kyle.tasksapp.ui.tasks.TasksViewModel_AssistedFactory;
import com.kyle.tasksapp.ui.tasks.TasksViewModel_AssistedFactory_Factory;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideApplicationFactory;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.MapBuilder;
import dagger.internal.MemoizedSentinel;
import dagger.internal.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
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
public final class DaggerTasksApp_HiltComponents_SingletonC extends TasksApp_HiltComponents.SingletonC {
  private final ApplicationContextModule applicationContextModule;

  private volatile Provider<TaskDatabase> provideDatabaseProvider;

  private volatile Object applicationScopeCoroutineScope = new MemoizedSentinel();

  private volatile Object taskDatabase = new MemoizedSentinel();

  private volatile Provider<TaskDao> provideTaskDaoProvider;

  private volatile Provider<CoroutineScope> provideApplicationScopeProvider;

  private volatile Object preferencesRepo = new MemoizedSentinel();

  private volatile Provider<PreferencesRepo> preferencesRepoProvider;

  private DaggerTasksApp_HiltComponents_SingletonC(
      ApplicationContextModule applicationContextModuleParam) {
    this.applicationContextModule = applicationContextModuleParam;
  }

  public static Builder builder() {
    return new Builder();
  }

  private Provider<TaskDatabase> getTaskDatabaseProvider() {
    Object local = provideDatabaseProvider;
    if (local == null) {
      local = new SwitchingProvider<>(1);
      provideDatabaseProvider = (Provider<TaskDatabase>) local;
    }
    return (Provider<TaskDatabase>) local;
  }

  private CoroutineScope getApplicationScopeCoroutineScope() {
    Object local = applicationScopeCoroutineScope;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = applicationScopeCoroutineScope;
        if (local instanceof MemoizedSentinel) {
          local = AppModule_ProvideApplicationScopeFactory.provideApplicationScope();
          applicationScopeCoroutineScope = DoubleCheck.reentrantCheck(applicationScopeCoroutineScope, local);
        }
      }
    }
    return (CoroutineScope) local;
  }

  private TaskDatabase.Callback getCallback() {
    return new TaskDatabase.Callback(getTaskDatabaseProvider(), getApplicationScopeCoroutineScope());
  }

  private TaskDatabase getTaskDatabase() {
    Object local = taskDatabase;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = taskDatabase;
        if (local instanceof MemoizedSentinel) {
          local = AppModule_ProvideDatabaseFactory.provideDatabase(ApplicationContextModule_ProvideApplicationFactory.provideApplication(applicationContextModule), getCallback());
          taskDatabase = DoubleCheck.reentrantCheck(taskDatabase, local);
        }
      }
    }
    return (TaskDatabase) local;
  }

  private TaskDao getTaskDao() {
    return AppModule_ProvideTaskDaoFactory.provideTaskDao(getTaskDatabase());
  }

  private Provider<TaskDao> getTaskDaoProvider() {
    Object local = provideTaskDaoProvider;
    if (local == null) {
      local = new SwitchingProvider<>(0);
      provideTaskDaoProvider = (Provider<TaskDao>) local;
    }
    return (Provider<TaskDao>) local;
  }

  private Provider<CoroutineScope> getApplicationScopeCoroutineScopeProvider() {
    Object local = provideApplicationScopeProvider;
    if (local == null) {
      local = new SwitchingProvider<>(2);
      provideApplicationScopeProvider = (Provider<CoroutineScope>) local;
    }
    return (Provider<CoroutineScope>) local;
  }

  private PreferencesRepo getPreferencesRepo() {
    Object local = preferencesRepo;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = preferencesRepo;
        if (local instanceof MemoizedSentinel) {
          local = new PreferencesRepo(ApplicationContextModule_ProvideContextFactory.provideContext(applicationContextModule));
          preferencesRepo = DoubleCheck.reentrantCheck(preferencesRepo, local);
        }
      }
    }
    return (PreferencesRepo) local;
  }

  private Provider<PreferencesRepo> getPreferencesRepoProvider() {
    Object local = preferencesRepoProvider;
    if (local == null) {
      local = new SwitchingProvider<>(3);
      preferencesRepoProvider = (Provider<PreferencesRepo>) local;
    }
    return (Provider<PreferencesRepo>) local;
  }

  @Override
  public void injectTasksApp(TasksApp tasksApp) {
  }

  @Override
  public ActivityRetainedComponentBuilder retainedComponentBuilder() {
    return new ActivityRetainedCBuilder();
  }

  @Override
  public ServiceComponentBuilder serviceComponentBuilder() {
    return new ServiceCBuilder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder appModule(AppModule appModule) {
      Preconditions.checkNotNull(appModule);
      return this;
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public TasksApp_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new DaggerTasksApp_HiltComponents_SingletonC(applicationContextModule);
    }
  }

  private final class ActivityRetainedCBuilder implements TasksApp_HiltComponents.ActivityRetainedC.Builder {
    @Override
    public TasksApp_HiltComponents.ActivityRetainedC build() {
      return new ActivityRetainedCImpl();
    }
  }

  private final class ActivityRetainedCImpl extends TasksApp_HiltComponents.ActivityRetainedC {
    private ActivityRetainedCImpl() {

    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder();
    }

    private final class ActivityCBuilder implements TasksApp_HiltComponents.ActivityC.Builder {
      private Activity activity;

      @Override
      public ActivityCBuilder activity(Activity arg0) {
        this.activity = Preconditions.checkNotNull(arg0);
        return this;
      }

      @Override
      public TasksApp_HiltComponents.ActivityC build() {
        Preconditions.checkBuilderRequirement(activity, Activity.class);
        return new ActivityCImpl(activity);
      }
    }

    private final class ActivityCImpl extends TasksApp_HiltComponents.ActivityC {
      private final Activity activity;

      private volatile Provider<DeleteCompletedViewModel_AssistedFactory> deleteCompletedViewModel_AssistedFactoryProvider;

      private volatile Provider<TaskAddViewModel_AssistedFactory> taskAddViewModel_AssistedFactoryProvider;

      private volatile Provider<TasksViewModel_AssistedFactory> tasksViewModel_AssistedFactoryProvider;

      private ActivityCImpl(Activity activityParam) {
        this.activity = activityParam;
      }

      private DeleteCompletedViewModel_AssistedFactory getDeleteCompletedViewModel_AssistedFactory(
          ) {
        return DeleteCompletedViewModel_AssistedFactory_Factory.newInstance(DaggerTasksApp_HiltComponents_SingletonC.this.getTaskDaoProvider(), DaggerTasksApp_HiltComponents_SingletonC.this.getApplicationScopeCoroutineScopeProvider());
      }

      private Provider<DeleteCompletedViewModel_AssistedFactory> getDeleteCompletedViewModel_AssistedFactoryProvider(
          ) {
        Object local = deleteCompletedViewModel_AssistedFactoryProvider;
        if (local == null) {
          local = new SwitchingProvider<>(0);
          deleteCompletedViewModel_AssistedFactoryProvider = (Provider<DeleteCompletedViewModel_AssistedFactory>) local;
        }
        return (Provider<DeleteCompletedViewModel_AssistedFactory>) local;
      }

      private TaskAddViewModel_AssistedFactory getTaskAddViewModel_AssistedFactory() {
        return TaskAddViewModel_AssistedFactory_Factory.newInstance(DaggerTasksApp_HiltComponents_SingletonC.this.getTaskDaoProvider());
      }

      private Provider<TaskAddViewModel_AssistedFactory> getTaskAddViewModel_AssistedFactoryProvider(
          ) {
        Object local = taskAddViewModel_AssistedFactoryProvider;
        if (local == null) {
          local = new SwitchingProvider<>(1);
          taskAddViewModel_AssistedFactoryProvider = (Provider<TaskAddViewModel_AssistedFactory>) local;
        }
        return (Provider<TaskAddViewModel_AssistedFactory>) local;
      }

      private TasksViewModel_AssistedFactory getTasksViewModel_AssistedFactory() {
        return TasksViewModel_AssistedFactory_Factory.newInstance(DaggerTasksApp_HiltComponents_SingletonC.this.getTaskDaoProvider(), DaggerTasksApp_HiltComponents_SingletonC.this.getPreferencesRepoProvider());
      }

      private Provider<TasksViewModel_AssistedFactory> getTasksViewModel_AssistedFactoryProvider() {
        Object local = tasksViewModel_AssistedFactoryProvider;
        if (local == null) {
          local = new SwitchingProvider<>(2);
          tasksViewModel_AssistedFactoryProvider = (Provider<TasksViewModel_AssistedFactory>) local;
        }
        return (Provider<TasksViewModel_AssistedFactory>) local;
      }

      private Map<String, Provider<ViewModelAssistedFactory<? extends ViewModel>>> getMapOfStringAndProviderOfViewModelAssistedFactoryOf(
          ) {
        return MapBuilder.<String, Provider<ViewModelAssistedFactory<? extends ViewModel>>>newMapBuilder(3).put("com.kyle.tasksapp.ui.deletecompleted.DeleteCompletedViewModel", (Provider) getDeleteCompletedViewModel_AssistedFactoryProvider()).put("com.kyle.tasksapp.ui.taskadd.TaskAddViewModel", (Provider) getTaskAddViewModel_AssistedFactoryProvider()).put("com.kyle.tasksapp.ui.tasks.TasksViewModel", (Provider) getTasksViewModel_AssistedFactoryProvider()).build();
      }

      private ViewModelProvider.Factory getProvideFactory() {
        return ViewModelFactoryModules_ActivityModule_ProvideFactoryFactory.provideFactory(activity, ApplicationContextModule_ProvideApplicationFactory.provideApplication(DaggerTasksApp_HiltComponents_SingletonC.this.applicationContextModule), getMapOfStringAndProviderOfViewModelAssistedFactoryOf());
      }

      @Override
      public void injectMainActivity(MainActivity mainActivity) {
      }

      @Override
      public Set<ViewModelProvider.Factory> getActivityViewModelFactory() {
        return Collections.<ViewModelProvider.Factory>singleton(getProvideFactory());
      }

      @Override
      public FragmentComponentBuilder fragmentComponentBuilder() {
        return new FragmentCBuilder();
      }

      @Override
      public ViewComponentBuilder viewComponentBuilder() {
        return new ViewCBuilder();
      }

      private final class FragmentCBuilder implements TasksApp_HiltComponents.FragmentC.Builder {
        private Fragment fragment;

        @Override
        public FragmentCBuilder fragment(Fragment arg0) {
          this.fragment = Preconditions.checkNotNull(arg0);
          return this;
        }

        @Override
        public TasksApp_HiltComponents.FragmentC build() {
          Preconditions.checkBuilderRequirement(fragment, Fragment.class);
          return new FragmentCImpl(fragment);
        }
      }

      private final class FragmentCImpl extends TasksApp_HiltComponents.FragmentC {
        private final Fragment fragment;

        private FragmentCImpl(Fragment fragmentParam) {
          this.fragment = fragmentParam;
        }

        private ViewModelProvider.Factory getProvideFactory() {
          return ViewModelFactoryModules_FragmentModule_ProvideFactoryFactory.provideFactory(fragment, ApplicationContextModule_ProvideApplicationFactory.provideApplication(DaggerTasksApp_HiltComponents_SingletonC.this.applicationContextModule), ActivityCImpl.this.getMapOfStringAndProviderOfViewModelAssistedFactoryOf());
        }

        @Override
        public void injectDeleteCompletedFragment(DeleteCompletedFragment deleteCompletedFragment) {
        }

        @Override
        public void injectTaskAddFragment(TaskAddFragment taskAddFragment) {
        }

        @Override
        public void injectTasksFragment(TasksFragment tasksFragment) {
        }

        @Override
        public Set<ViewModelProvider.Factory> getFragmentViewModelFactory() {
          return Collections.<ViewModelProvider.Factory>singleton(getProvideFactory());
        }

        @Override
        public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
          return new ViewWithFragmentCBuilder();
        }

        private final class ViewWithFragmentCBuilder implements TasksApp_HiltComponents.ViewWithFragmentC.Builder {
          private View view;

          @Override
          public ViewWithFragmentCBuilder view(View arg0) {
            this.view = Preconditions.checkNotNull(arg0);
            return this;
          }

          @Override
          public TasksApp_HiltComponents.ViewWithFragmentC build() {
            Preconditions.checkBuilderRequirement(view, View.class);
            return new ViewWithFragmentCImpl(view);
          }
        }

        private final class ViewWithFragmentCImpl extends TasksApp_HiltComponents.ViewWithFragmentC {
          private ViewWithFragmentCImpl(View view) {

          }
        }
      }

      private final class ViewCBuilder implements TasksApp_HiltComponents.ViewC.Builder {
        private View view;

        @Override
        public ViewCBuilder view(View arg0) {
          this.view = Preconditions.checkNotNull(arg0);
          return this;
        }

        @Override
        public TasksApp_HiltComponents.ViewC build() {
          Preconditions.checkBuilderRequirement(view, View.class);
          return new ViewCImpl(view);
        }
      }

      private final class ViewCImpl extends TasksApp_HiltComponents.ViewC {
        private ViewCImpl(View view) {

        }
      }

      private final class SwitchingProvider<T> implements Provider<T> {
        private final int id;

        SwitchingProvider(int id) {
          this.id = id;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T get() {
          switch (id) {
            case 0: // com.kyle.tasksapp.ui.deletecompleted.DeleteCompletedViewModel_AssistedFactory 
            return (T) ActivityCImpl.this.getDeleteCompletedViewModel_AssistedFactory();

            case 1: // com.kyle.tasksapp.ui.taskadd.TaskAddViewModel_AssistedFactory 
            return (T) ActivityCImpl.this.getTaskAddViewModel_AssistedFactory();

            case 2: // com.kyle.tasksapp.ui.tasks.TasksViewModel_AssistedFactory 
            return (T) ActivityCImpl.this.getTasksViewModel_AssistedFactory();

            default: throw new AssertionError(id);
          }
        }
      }
    }
  }

  private final class ServiceCBuilder implements TasksApp_HiltComponents.ServiceC.Builder {
    private Service service;

    @Override
    public ServiceCBuilder service(Service arg0) {
      this.service = Preconditions.checkNotNull(arg0);
      return this;
    }

    @Override
    public TasksApp_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(service);
    }
  }

  private final class ServiceCImpl extends TasksApp_HiltComponents.ServiceC {
    private ServiceCImpl(Service service) {

    }
  }

  private final class SwitchingProvider<T> implements Provider<T> {
    private final int id;

    SwitchingProvider(int id) {
      this.id = id;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get() {
      switch (id) {
        case 0: // com.kyle.tasksapp.data.TaskDao 
        return (T) DaggerTasksApp_HiltComponents_SingletonC.this.getTaskDao();

        case 1: // com.kyle.tasksapp.data.TaskDatabase 
        return (T) DaggerTasksApp_HiltComponents_SingletonC.this.getTaskDatabase();

        case 2: // @com.kyle.tasksapp.di.ApplicationScope kotlinx.coroutines.CoroutineScope 
        return (T) DaggerTasksApp_HiltComponents_SingletonC.this.getApplicationScopeCoroutineScope();

        case 3: // com.kyle.tasksapp.data.PreferencesRepo 
        return (T) DaggerTasksApp_HiltComponents_SingletonC.this.getPreferencesRepo();

        default: throw new AssertionError(id);
      }
    }
  }
}
