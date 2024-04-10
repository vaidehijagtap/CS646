package com.pprior.quizz.di;

import com.pprior.quizz.domain.repositories.QuestionRepositoryImpl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
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
public final class DomainModule_ProvideQuestionRepositoryFactory implements Factory<QuestionRepositoryImpl> {
  @Override
  public QuestionRepositoryImpl get() {
    return provideQuestionRepository();
  }

  public static DomainModule_ProvideQuestionRepositoryFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static QuestionRepositoryImpl provideQuestionRepository() {
    return Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideQuestionRepository());
  }

  private static final class InstanceHolder {
    private static final DomainModule_ProvideQuestionRepositoryFactory INSTANCE = new DomainModule_ProvideQuestionRepositoryFactory();
  }
}
