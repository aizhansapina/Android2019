package com.eyezhann.movieguide.listing;

import com.eyezhann.movieguide.Movie;

import java.util.List;

import io.reactivex.Observable;


public interface MoviesListingInteractor
{
    Observable<List<Movie>> fetchMovies(int page);
    Observable<List<Movie>> searchMovie(String searchQuery);
}
