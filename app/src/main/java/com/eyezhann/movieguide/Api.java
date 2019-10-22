package com.eyezhann.movieguide;


public class Api {
    public static final String BASE_POSTER_PATH = "http://image.tmdb.org/t/p/w342";
    public static final String BASR_BACKDROP_PATH = "http://image.tmdb.org/t/p/w780";

    private Api() {
        // hide implicit public constructor
    }

    public static String getPosterPath(String posterPath) {
        return BASE_POSTER_PATH + posterPath;
    }

    public static String getBackdropPath(String backdropPath) {
        return BASR_BACKDROP_PATH + backdropPath;
    }
}
