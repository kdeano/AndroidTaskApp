// Generated by view binder compiler. Do not edit!
package com.kyle.tasksapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kyle.tasksapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentTasksBinding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  @NonNull
  public final FloatingActionButton fabAddTask;

  @NonNull
  public final RecyclerView recyclerViewTasks;

  private FragmentTasksBinding(@NonNull CoordinatorLayout rootView,
      @NonNull FloatingActionButton fabAddTask, @NonNull RecyclerView recyclerViewTasks) {
    this.rootView = rootView;
    this.fabAddTask = fabAddTask;
    this.recyclerViewTasks = recyclerViewTasks;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentTasksBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentTasksBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_tasks, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentTasksBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.fab_add_task;
      FloatingActionButton fabAddTask = rootView.findViewById(id);
      if (fabAddTask == null) {
        break missingId;
      }

      id = R.id.recycler_view_tasks;
      RecyclerView recyclerViewTasks = rootView.findViewById(id);
      if (recyclerViewTasks == null) {
        break missingId;
      }

      return new FragmentTasksBinding((CoordinatorLayout) rootView, fabAddTask, recyclerViewTasks);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
