package com.eyezhann.movieguide.listing;

import com.eyezhann.movieguide.network.TmdbWebService;

import dagger.Module;
import dagger.Provides;


@Module
public class ListingModule {
    @Provides
    MoviesListingInteractor provideMovieListingInteractor(TmdbWebService tmdbWebService) {
        return new MoviesListingInteractorImpl(tmdbWebService);
    }

    @Provides
    MoviesListingPresenter provideMovieListingPresenter(MoviesListingInteractor interactor) {
        return new MoviesListingPresenterImpl(interactor);
    }
}
