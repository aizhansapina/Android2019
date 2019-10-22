package com.eyezhann.movieguide.details;

import com.eyezhann.movieguide.Review;
import com.eyezhann.movieguide.ReviewsWrapper;
import com.eyezhann.movieguide.network.TmdbWebService;

import java.util.List;

import io.reactivex.Observable;


class MovieDetailsInteractorImpl implements MovieDetailsInteractor {

    private TmdbWebService tmdbWebService;

    MovieDetailsInteractorImpl(TmdbWebService tmdbWebService) {
        this.tmdbWebService = tmdbWebService;
    }

    @Override
    public Observable<List<Review>> getReviews(final String id) {
        return tmdbWebService.reviews(id).map(ReviewsWrapper::getReviews);
    }

}
