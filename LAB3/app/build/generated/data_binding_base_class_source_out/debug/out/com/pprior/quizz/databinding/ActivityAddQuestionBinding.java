// Generated by view binder compiler. Do not edit!
package com.pprior.quizz.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.pprior.quizz.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityAddQuestionBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageButton closeButton;

  @NonNull
  public final TextView errorMessage;

  @NonNull
  public final EditText questionQuestion;

  @NonNull
  public final ImageView questionTypeIcon;

  @NonNull
  public final Button saveButton;

  private ActivityAddQuestionBinding(@NonNull LinearLayout rootView,
      @NonNull ImageButton closeButton, @NonNull TextView errorMessage,
      @NonNull EditText questionQuestion, @NonNull ImageView questionTypeIcon,
      @NonNull Button saveButton) {
    this.rootView = rootView;
    this.closeButton = closeButton;
    this.errorMessage = errorMessage;
    this.questionQuestion = questionQuestion;
    this.questionTypeIcon = questionTypeIcon;
    this.saveButton = saveButton;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAddQuestionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAddQuestionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_add_question, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAddQuestionBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.close_button;
      ImageButton closeButton = ViewBindings.findChildViewById(rootView, id);
      if (closeButton == null) {
        break missingId;
      }

      id = R.id.error_message;
      TextView errorMessage = ViewBindings.findChildViewById(rootView, id);
      if (errorMessage == null) {
        break missingId;
      }

      id = R.id.question_question;
      EditText questionQuestion = ViewBindings.findChildViewById(rootView, id);
      if (questionQuestion == null) {
        break missingId;
      }

      id = R.id.question_type_icon;
      ImageView questionTypeIcon = ViewBindings.findChildViewById(rootView, id);
      if (questionTypeIcon == null) {
        break missingId;
      }

      id = R.id.save_button;
      Button saveButton = ViewBindings.findChildViewById(rootView, id);
      if (saveButton == null) {
        break missingId;
      }

      return new ActivityAddQuestionBinding((LinearLayout) rootView, closeButton, errorMessage,
          questionQuestion, questionTypeIcon, saveButton);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}