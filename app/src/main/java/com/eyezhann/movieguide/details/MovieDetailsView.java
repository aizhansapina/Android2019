package com.eyezhann.movieguide.details;

import com.eyezhann.movieguide.Movie;
import com.eyezhann.movieguide.Review;

import java.util.List;


interface MovieDetailsView
{
    void showDetails(Movie movie);
    void showReviews(List<Review> reviews);
}
