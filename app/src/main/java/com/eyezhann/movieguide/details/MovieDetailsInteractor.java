package com.eyezhann.movieguide.details;

import com.eyezhann.movieguide.Review;

import java.util.List;

import io.reactivex.Observable;


public interface MovieDetailsInteractor
{
    Observable<List<Review>> getReviews(String id);
}
