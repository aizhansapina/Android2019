package com.eyezhann.movieguide.listing;

import com.eyezhann.movieguide.network.TmdbWebService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ListingModule_ProvideMovieListingInteractorFactory
    implements Factory<MoviesListingInteractor> {
  private final ListingModule module;

  private final Provider<TmdbWebService> tmdbWebServiceProvider;

  public ListingModule_ProvideMovieListingInteractorFactory(
      ListingModule module, Provider<TmdbWebService> tmdbWebServiceProvider) {
    assert module != null;
    this.module = module;
    assert tmdbWebServiceProvider != null;
    this.tmdbWebServiceProvider = tmdbWebServiceProvider;
  }

  @Override
  public MoviesListingInteractor get() {
    return Preconditions.checkNotNull(
        module.provideMovieListingInteractor(tmdbWebServiceProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<MoviesListingInteractor> create(
      ListingModule module, Provider<TmdbWebService> tmdbWebServiceProvider) {
    return new ListingModule_ProvideMovieListingInteractorFactory(module, tmdbWebServiceProvider);
  }
}
