package com.pprior.quizz.ui.viewModels;

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
public final class UserViewModel_Factory implements Factory<UserViewModel> {
  private final Provider<UsersRepositoryImpl> repositoryImplProvider;

  public UserViewModel_Factory(Provider<UsersRepositoryImpl> repositoryImplProvider) {
    this.repositoryImplProvider = repositoryImplProvider;
  }

  @Override
  public UserViewModel get() {
    return newInstance(repositoryImplProvider.get());
  }

  public static UserViewModel_Factory create(Provider<UsersRepositoryImpl> repositoryImplProvider) {
    return new UserViewModel_Factory(repositoryImplProvider);
  }

  public static UserViewModel newInstance(UsersRepositoryImpl repositoryImpl) {
    return new UserViewModel(repositoryImpl);
  }
}
