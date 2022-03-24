package com.kyle.tasksapp.ui.deletecompleted;

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
    topLevelClass = DeleteCompletedViewModel.class
)
public interface DeleteCompletedViewModel_HiltModule {
  @Binds
  @IntoMap
  @StringKey("com.kyle.tasksapp.ui.deletecompleted.DeleteCompletedViewModel")
  ViewModelAssistedFactory<? extends ViewModel> bind(
      DeleteCompletedViewModel_AssistedFactory factory);
}
