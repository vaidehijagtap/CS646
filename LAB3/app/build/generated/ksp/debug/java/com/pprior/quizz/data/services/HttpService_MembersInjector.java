package com.pprior.quizz.data.services;

import com.pprior.quizz.data.controllers.HttpController;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class HttpService_MembersInjector implements MembersInjector<HttpService> {
  private final Provider<HttpController> controllerProvider;

  public HttpService_MembersInjector(Provider<HttpController> controllerProvider) {
    this.controllerProvider = controllerProvider;
  }

  public static MembersInjector<HttpService> create(Provider<HttpController> controllerProvider) {
    return new HttpService_MembersInjector(controllerProvider);
  }

  @Override
  public void injectMembers(HttpService instance) {
    injectController(instance, controllerProvider.get());
  }

  @InjectedFieldSignature("com.pprior.quizz.data.services.HttpService.controller")
  public static void injectController(HttpService instance, HttpController controller) {
    instance.controller = controller;
  }
}
