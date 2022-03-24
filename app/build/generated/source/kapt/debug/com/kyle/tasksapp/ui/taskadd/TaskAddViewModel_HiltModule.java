package com.kyle.tasksapp.ui.taskadd;

import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.codegen.OriginatingElement;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import javax.annotation.Generated;

@Generated("androidx.hilt.AndroidXHiltProcessor")
@Module
@InstallIn(ActivityRetainedComponent.class)
@OriginatingElement(
    topLevelClass = TaskAddViewModel.class
)
public interface TaskAddViewModel_HiltModule {
  @Binds
  @IntoMap
  @StringKey("com.kyle.tasksapp.ui.taskadd.TaskAddViewModel")
  ViewModelAssistedFactory<? extends ViewModel> bind(TaskAddViewModel_AssistedFactory factory);
}
