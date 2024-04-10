package com.pprior.quizz.data.controllers;

import com.pprior.quizz.data.repositories.HttpRepositoryImpl;
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
public final class HttpController_Factory implements Factory<HttpController> {
  private final Provider<HttpRepositoryImpl> repositoryProvider;

  public HttpController_Factory(Provider<HttpRepositoryImpl> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public HttpController get() {
    return newInstance(repositoryProvider.get());
  }

  public static HttpController_Factory create(Provider<HttpRepositoryImpl> repositoryProvider) {
    return new HttpController_Factory(repositoryProvider);
  }

  public static HttpController newInstance(HttpRepositoryImpl repository) {
    return new HttpController(repository);
  }
}
