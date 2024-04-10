package com.pprior.quizz.di;

import com.pprior.quizz.domain.repositories.UsersRepositoryImpl;
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
public final class DomainModule_ProvideUsersRepositoryFactory implements Factory<UsersRepositoryImpl> {
  @Override
  public UsersRepositoryImpl get() {
    return provideUsersRepository();
  }

  public static DomainModule_ProvideUsersRepositoryFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static UsersRepositoryImpl provideUsersRepository() {
    return Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideUsersRepository());
  }

  private static final class InstanceHolder {
    private static final DomainModule_ProvideUsersRepositoryFactory INSTANCE = new DomainModule_ProvideUsersRepositoryFactory();
  }
}
