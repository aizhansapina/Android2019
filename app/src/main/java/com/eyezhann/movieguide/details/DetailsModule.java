package com.eyezhann.movieguide.details;

import com.eyezhann.movieguide.network.TmdbWebService;

import dagger.Module;
import dagger.Provides;


@Module
public class DetailsModule {
    @Provides
    @DetailsScope
    MovieDetailsInteractor provideInteractor(TmdbWebService tmdbWebService) {
        return new MovieDetailsInteractorImpl(tmdbWebService);
    }

    @Provides
    @DetailsScope
    MovieDetailsPresenter providePresenter(MovieDetailsInteractor detailsInteractor
                                           ) {
        return new MovieDetailsPresenterImpl(detailsInteractor);
    }
}
