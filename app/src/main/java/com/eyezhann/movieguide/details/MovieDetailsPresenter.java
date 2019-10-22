package com.eyezhann.movieguide.details;

import com.eyezhann.movieguide.Movie;

public interface MovieDetailsPresenter
{
    void showDetails(Movie movie);

    void showReviews(Movie movie);

    void setView(MovieDetailsView view);

}
