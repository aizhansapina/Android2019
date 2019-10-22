package com.eyezhann.movieguide;

import android.app.Application;
import android.os.StrictMode;

import com.eyezhann.movieguide.DaggerAppComponent;
import com.eyezhann.movieguide.details.DetailsComponent;
import com.eyezhann.movieguide.details.DetailsModule;
import com.eyezhann.movieguide.listing.ListingComponent;
import com.eyezhann.movieguide.listing.ListingModule;
import com.eyezhann.movieguide.network.NetworkModule;

import io.realm.Realm;


public class BaseApplication extends Application
{
    private AppComponent appComponent;
    private DetailsComponent detailsComponent;
    private ListingComponent listingComponent;

    @Override
    public void onCreate()
    {
        super.onCreate();
        StrictMode.enableDefaults();
        initRealm();
        appComponent = createAppComponent();
    }

    private AppComponent createAppComponent()
    {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    private void initRealm(){
        Realm.init(this);
    }

    public DetailsComponent createDetailsComponent()
    {
        detailsComponent = appComponent.plus(new DetailsModule());
        return detailsComponent;
    }

    public void releaseDetailsComponent()
    {
        detailsComponent = null;
    }

    public ListingComponent createListingComponent()
    {
        listingComponent = appComponent.plus(new ListingModule());
        return listingComponent;
    }

    public void releaseListingComponent()
    {
        listingComponent = null;
    }

    public ListingComponent getListingComponent()
    {
        return listingComponent;
    }
}
