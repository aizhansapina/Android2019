package com.eyezhann.movieguide;

import com.eyezhann.movieguide.details.DetailsComponent;
import com.eyezhann.movieguide.details.DetailsModule;
import com.eyezhann.movieguide.details.DetailsModule_ProvideInteractorFactory;
import com.eyezhann.movieguide.details.DetailsModule_ProvidePresenterFactory;
import com.eyezhann.movieguide.details.MovieDetailsFragment;
import com.eyezhann.movieguide.details.MovieDetailsFragment_MembersInjector;
import com.eyezhann.movieguide.details.MovieDetailsInteractor;
import com.eyezhann.movieguide.details.MovieDetailsPresenter;
import com.eyezhann.movieguide.listing.ListingComponent;
import com.eyezhann.movieguide.listing.ListingModule;
import com.eyezhann.movieguide.listing.ListingModule_ProvideMovieListingInteractorFactory;
import com.eyezhann.movieguide.listing.ListingModule_ProvideMovieListingPresenterFactory;
import com.eyezhann.movieguide.listing.MoviesListingFragment;
import com.eyezhann.movieguide.listing.MoviesListingFragment_MembersInjector;
import com.eyezhann.movieguide.listing.MoviesListingInteractor;
import com.eyezhann.movieguide.listing.MoviesListingPresenter;
import com.eyezhann.movieguide.network.NetworkModule;
import com.eyezhann.movieguide.network.NetworkModule_ProvideOkHttpClientFactory;
import com.eyezhann.movieguide.network.NetworkModule_RetrofitFactory;
import com.eyezhann.movieguide.network.NetworkModule_TmdbWebServiceFactory;
import com.eyezhann.movieguide.network.RequestInterceptor;
import com.eyezhann.movieguide.network.RequestInterceptor_Factory;
import com.eyezhann.movieguide.network.TmdbWebService;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerAppComponent implements AppComponent {
  private Provider<RequestInterceptor> requestInterceptorProvider;

  private Provider<OkHttpClient> provideOkHttpClientProvider;

  private Provider<Retrofit> retrofitProvider;

  private Provider<TmdbWebService> tmdbWebServiceProvider;

  private DaggerAppComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static AppComponent create() {
    return builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.requestInterceptorProvider = DoubleCheck.provider(RequestInterceptor_Factory.create());

    this.provideOkHttpClientProvider =
        DoubleCheck.provider(
            NetworkModule_ProvideOkHttpClientFactory.create(
                builder.networkModule, requestInterceptorProvider));

    this.retrofitProvider =
        DoubleCheck.provider(
            NetworkModule_RetrofitFactory.create(
                builder.networkModule, provideOkHttpClientProvider));

    this.tmdbWebServiceProvider =
        DoubleCheck.provider(
            NetworkModule_TmdbWebServiceFactory.create(builder.networkModule, retrofitProvider));
  }

  @Override
  public DetailsComponent plus(DetailsModule detailsModule) {
    return new DetailsComponentImpl(detailsModule);
  }

  @Override
  public ListingComponent plus(ListingModule listingModule) {
    return new ListingComponentImpl(listingModule);
  }

  public static final class Builder {
    private NetworkModule networkModule;

    private Builder() {}

    public AppComponent build() {
      if (networkModule == null) {
        this.networkModule = new NetworkModule();
      }
      return new DaggerAppComponent(this);
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://google.github.io/dagger/unused-modules.
     */
    @Deprecated
    public Builder appModule(AppModule appModule) {
      Preconditions.checkNotNull(appModule);
      return this;
    }

    public Builder networkModule(NetworkModule networkModule) {
      this.networkModule = Preconditions.checkNotNull(networkModule);
      return this;
    }
  }

  private final class DetailsComponentImpl implements DetailsComponent {
    private final DetailsModule detailsModule;

    private Provider<MovieDetailsInteractor> provideInteractorProvider;

    private Provider<MovieDetailsPresenter> providePresenterProvider;

    private MembersInjector<MovieDetailsFragment> movieDetailsFragmentMembersInjector;

    private DetailsComponentImpl(DetailsModule detailsModule) {
      this.detailsModule = Preconditions.checkNotNull(detailsModule);
      initialize();
    }

    @SuppressWarnings("unchecked")
    private void initialize() {

      this.provideInteractorProvider =
          DoubleCheck.provider(
              DetailsModule_ProvideInteractorFactory.create(
                  detailsModule, DaggerAppComponent.this.tmdbWebServiceProvider));

      this.providePresenterProvider =
          DoubleCheck.provider(
              DetailsModule_ProvidePresenterFactory.create(
                  detailsModule, provideInteractorProvider));

      this.movieDetailsFragmentMembersInjector =
          MovieDetailsFragment_MembersInjector.create(providePresenterProvider);
    }

    @Override
    public void inject(MovieDetailsFragment target) {
      movieDetailsFragmentMembersInjector.injectMembers(target);
    }
  }

  private final class ListingComponentImpl implements ListingComponent {
    private final ListingModule listingModule;

    private Provider<MoviesListingInteractor> provideMovieListingInteractorProvider;

    private Provider<MoviesListingPresenter> provideMovieListingPresenterProvider;

    private MembersInjector<MoviesListingFragment> moviesListingFragmentMembersInjector;

    private ListingComponentImpl(ListingModule listingModule) {
      this.listingModule = Preconditions.checkNotNull(listingModule);
      initialize();
    }

    @SuppressWarnings("unchecked")
    private void initialize() {

      this.provideMovieListingInteractorProvider =
          ListingModule_ProvideMovieListingInteractorFactory.create(
              listingModule, DaggerAppComponent.this.tmdbWebServiceProvider);

      this.provideMovieListingPresenterProvider =
          ListingModule_ProvideMovieListingPresenterFactory.create(
              listingModule, provideMovieListingInteractorProvider);

      this.moviesListingFragmentMembersInjector =
          MoviesListingFragment_MembersInjector.create(provideMovieListingPresenterProvider);
    }

    @Override
    public MoviesListingFragment inject(MoviesListingFragment fragment) {
      moviesListingFragmentMembersInjector.injectMembers(fragment);
      return fragment;
    }
  }
}
