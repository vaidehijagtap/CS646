package com.pprior.quizz.di;

import com.pprior.quizz.data.controllers.HttpController;
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
public final class DataModule_ProvideQuestionControllerFactory implements Factory<HttpController> {
  @Override
  public HttpController get() {
    return provideQuestionController();
  }

  public static DataModule_ProvideQuestionControllerFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static HttpController provideQuestionController() {
    return Preconditions.checkNotNullFromProvides(DataModule.INSTANCE.provideQuestionController());
  }

  private static final class InstanceHolder {
    private static final DataModule_ProvideQuestionControllerFactory INSTANCE = new DataModule_ProvideQuestionControllerFactory();
  }
}