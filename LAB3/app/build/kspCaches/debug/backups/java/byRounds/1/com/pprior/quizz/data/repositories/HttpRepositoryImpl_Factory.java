package com.pprior.quizz.data.repositories;

import com.pprior.quizz.domain.repositories.QuestionRepositoryImpl;
import com.pprior.quizz.domain.repositories.UsersRepositoryImpl;
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
public final class HttpRepositoryImpl_Factory implements Factory<HttpRepositoryImpl> {
  private final Provider<QuestionRepositoryImpl> questionRepositoryProvider;

  private final Provider<UsersRepositoryImpl> usersRepositoryProvider;

  public HttpRepositoryImpl_Factory(Provider<QuestionRepositoryImpl> questionRepositoryProvider,
      Provider<UsersRepositoryImpl> usersRepositoryProvider) {
    this.questionRepositoryProvider = questionRepositoryProvider;
    this.usersRepositoryProvider = usersRepositoryProvider;
  }

  @Override
  public HttpRepositoryImpl get() {
    return newInstance(questionRepositoryProvider.get(), usersRepositoryProvider.get());
  }

  public static HttpRepositoryImpl_Factory create(
      Provider<QuestionRepositoryImpl> questionRepositoryProvider,
      Provider<UsersRepositoryImpl> usersRepositoryProvider) {
    return new HttpRepositoryImpl_Factory(questionRepositoryProvider, usersRepositoryProvider);
  }

  public static HttpRepositoryImpl newInstance(QuestionRepositoryImpl questionRepository,
      UsersRepositoryImpl usersRepository) {
    return new HttpRepositoryImpl(questionRepository, usersRepository);
  }
}
