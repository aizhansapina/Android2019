package com.eyezhann.movieguide;

import com.eyezhann.movieguide.details.DetailsComponent;
import com.eyezhann.movieguide.details.DetailsModule;
import com.eyezhann.movieguide.listing.ListingComponent;
import com.eyezhann.movieguide.listing.ListingModule;
import com.eyezhann.movieguide.network.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class})
public interface AppComponent
{
    DetailsComponent plus(DetailsModule detailsModule);

    ListingComponent plus(ListingModule listingModule);
}
