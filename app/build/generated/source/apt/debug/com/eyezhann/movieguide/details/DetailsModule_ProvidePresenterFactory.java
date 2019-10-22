package com.eyezhann.movieguide.details;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DetailsModule_ProvidePresenterFactory implements Factory<MovieDetailsPresenter> {
  private final DetailsModule module;

  private final Provider<MovieDetailsInteractor> detailsInteractorProvider;

  public DetailsModule_ProvidePresenterFactory(
      DetailsModule module, Provider<MovieDetailsInteractor> detailsInteractorProvider) {
    assert module != null;
    this.module = module;
    assert detailsInteractorProvider != null;
    this.detailsInteractorProvider = detailsInteractorProvider;
  }

  @Override
  public MovieDetailsPresenter get() {
    return Preconditions.checkNotNull(
        module.providePresenter(detailsInteractorProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<MovieDetailsPresenter> create(
      DetailsModule module, Provider<MovieDetailsInteractor> detailsInteractorProvider) {
    return new DetailsModule_ProvidePresenterFactory(module, detailsInteractorProvider);
  }
}
