// Generated by view binder compiler. Do not edit!
package com.pprior.quizz.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.pprior.quizz.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityQuestionTypeBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final FragmentContainerView cardsTypes;

  @NonNull
  public final FragmentContainerView headerFragment;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final TextView title;

  private ActivityQuestionTypeBinding(@NonNull ConstraintLayout rootView,
      @NonNull FragmentContainerView cardsTypes, @NonNull FragmentContainerView headerFragment,
      @NonNull ConstraintLayout main, @NonNull TextView title) {
    this.rootView = rootView;
    this.cardsTypes = cardsTypes;
    this.headerFragment = headerFragment;
    this.main = main;
    this.title = title;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityQuestionTypeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityQuestionTypeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_question_type, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityQuestionTypeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cards_types;
      FragmentContainerView cardsTypes = ViewBindings.findChildViewById(rootView, id);
      if (cardsTypes == null) {
        break missingId;
      }

      id = R.id.header_fragment;
      FragmentContainerView headerFragment = ViewBindings.findChildViewById(rootView, id);
      if (headerFragment == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.title;
      TextView title = ViewBindings.findChildViewById(rootView, id);
      if (title == null) {
        break missingId;
      }

      return new ActivityQuestionTypeBinding((ConstraintLayout) rootView, cardsTypes,
          headerFragment, main, title);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
