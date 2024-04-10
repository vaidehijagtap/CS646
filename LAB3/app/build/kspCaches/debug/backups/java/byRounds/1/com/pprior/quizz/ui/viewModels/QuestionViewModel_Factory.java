package com.pprior.quizz.ui.viewModels;

import com.pprior.quizz.domain.repositories.QuestionRepositoryImpl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class QuestionViewModel_Factory implements Factory<QuestionViewModel> {
  private final Provider<QuestionRepositoryImpl> repositoryImplProvider;

  public QuestionViewModel_Factory(Provider<QuestionRepositoryImpl> repositoryImplProvider) {
    this.repositoryImplProvider = repositoryImplProvider;
  }

  @Override
  public QuestionViewModel get() {
    return newInstance(repositoryImplProvider.get());
  }

  public static QuestionViewModel_Factory create(
      Provider<QuestionRepositoryImpl> repositoryImplProvider) {
    return new QuestionViewModel_Factory(repositoryImplProvider);
  }

  public static QuestionViewModel newInstance(QuestionRepositoryImpl repositoryImpl) {
    return new QuestionViewModel(repositoryImpl);
  }
}
