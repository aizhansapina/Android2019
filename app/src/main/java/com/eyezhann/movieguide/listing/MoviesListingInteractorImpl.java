package com.eyezhann.movieguide.listing;

import android.support.annotation.NonNull;
import com.eyezhann.movieguide.Movie;
import com.eyezhann.movieguide.MoviesWraper;
import com.eyezhann.movieguide.network.TmdbWebService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import io.reactivex.Observable;


class MoviesListingInteractorImpl implements MoviesListingInteractor {

    private TmdbWebService tmdbWebService;

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final int NEWEST_MIN_VOTE_COUNT = 50;

    MoviesListingInteractorImpl(TmdbWebService tmdbWebService) {

        this.tmdbWebService = tmdbWebService;
    }



    @Override
    public Observable<List<Movie>> fetchMovies(int page) {
        return tmdbWebService.popularMovies(page).map(MoviesWraper::getMovieList);

    }

    @Override
    public Observable<List<Movie>> searchMovie(@NonNull String searchQuery) {
        return tmdbWebService.searchMovies(searchQuery).map(MoviesWraper::getMovieList);
    }

}
