package com.pprior.quizz.di;

import com.pprior.quizz.data.repositories.HttpRepositoryImpl;
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
public final class DataModule_ProvideServerRepositoryFactory implements Factory<HttpRepositoryImpl> {
  @Override
  public HttpRepositoryImpl get() {
    return provideServerRepository();
  }

  public static DataModule_ProvideServerRepositoryFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static HttpRepositoryImpl provideServerRepository() {
    return Preconditions.checkNotNullFromProvides(DataModule.INSTANCE.provideServerRepository());
  }

  private static final class InstanceHolder {
    private static final DataModule_ProvideServerRepositoryFactory INSTANCE = new DataModule_ProvideServerRepositoryFactory();
  }
}
