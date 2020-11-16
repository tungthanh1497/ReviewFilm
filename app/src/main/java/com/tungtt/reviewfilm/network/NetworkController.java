package com.tungtt.reviewfilm.network;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.tungtt.reviewfilm.network.models.SimpleResponse;
import com.tungtt.reviewfilm.network.models.getdetails.response.GetDetailsResponse;
import com.tungtt.reviewfilm.network.models.getlistmovies.response.GetListMoviesResponse;
import com.tungtt.reviewfilm.network.models.getvideos.response.GetVideosResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tungtt a.k.a TungTT
 * On Mon, 09 Nov 2020 - 14:30
 */
public class NetworkController {

    private static final String mApiKey = "903e590a2abad3f55bbb731d3c363eda";
    private static final String mLanguage = "en-US";
    private static final String mPage = "1";

    private static IApiService mApiBuilder;


    private static IApiService getAPIBuilder() {
        if (mApiBuilder == null) {
            OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
            builder.addInterceptor(chain -> {
                Request request = chain.request();
                HttpUrl url = request.url().newBuilder()
                        .addQueryParameter("api_key", mApiKey)
                        .addQueryParameter("language", mLanguage)
                        .addQueryParameter("page", mPage)
                        .build();
                request = request.newBuilder().url(url).build();
                return chain.proceed(request);
            })
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .addNetworkInterceptor(new StethoInterceptor())
                    .readTimeout(30, TimeUnit.SECONDS)
                    .connectTimeout(30, TimeUnit.SECONDS);
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(builder.build())
                    .build();
            mApiBuilder = retrofit.create(IApiService.class);
        }
        return mApiBuilder;
    }

    public static Observable<Response<GetListMoviesResponse>> getUpcoming(CommonCallback<GetListMoviesResponse> callback) {
        return initObservable(getAPIBuilder().getUpcoming(), callback);
    }

    public static Observable<Response<GetListMoviesResponse>> getTopRated(CommonCallback<GetListMoviesResponse> callback) {
        return initObservable(getAPIBuilder().getTopRated(), callback);
    }

    public static Observable<Response<GetListMoviesResponse>> getPopular(CommonCallback<GetListMoviesResponse> callback) {
        return initObservable(getAPIBuilder().getPopular(), callback);
    }

    public static Observable<Response<GetListMoviesResponse>> getNowPlaying(CommonCallback<GetListMoviesResponse> callback) {
        return initObservable(getAPIBuilder().getNowPlaying(), callback);
    }

    public static Observable<Response<GetDetailsResponse>> getDetails(String movieId,
                                                                      CommonCallback<GetDetailsResponse> callback) {
        return initObservable(getAPIBuilder().getDetails(movieId), callback);
    }

    public static Observable<Response<GetVideosResponse>> getVideos(String movieId,
                                                                    CommonCallback<GetVideosResponse> callback) {
        return initObservable(getAPIBuilder().getVideos(movieId), callback);
    }

    public static Observable<Response<GetListMoviesResponse>> getSimilarMovies(String movieId,
                                                                               CommonCallback<GetListMoviesResponse> callback) {
        return initObservable(getAPIBuilder().getSimilarMovies(movieId), callback);
    }

    public static Observable<Response<GetListMoviesResponse>> getRecommendationsMovies(String movieId,
                                                                                       CommonCallback<GetListMoviesResponse> callback) {
        return initObservable(getAPIBuilder().getRecommendationsMovies(movieId), callback);
    }

    private static Observable<Response<GetListMoviesResponse>> searchMovie(String query,
                                                                           CommonCallback<GetListMoviesResponse> callback) {
        return initObservable(getAPIBuilder().searchMovies(query), callback);
    }

    public static void searchMovies(String query,
                                    CommonCallback<GetListMoviesResponse> callback) {
        searchMovie(query, callback).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    public static void getAllTabData(Observer<Object> observer,
                                     CommonCallback<GetListMoviesResponse> upcomingCallback,
                                     CommonCallback<GetListMoviesResponse> topRatedCallback,
                                     CommonCallback<GetListMoviesResponse> popularCallback,
                                     CommonCallback<GetListMoviesResponse> nowPlayingCallback) {
        List<Observable<?>> observableList = new ArrayList<>();

        observableList.add(getUpcoming(upcomingCallback));
        observableList.add(getTopRated(topRatedCallback));
        observableList.add(getPopular(popularCallback));
        observableList.add(getNowPlaying(nowPlayingCallback));

        Observable.mergeDelayError(observableList)
                .observeOn(AndroidSchedulers.mainThread(), true)
                .subscribe(observer);
    }

    private static <T extends SimpleResponse> Observable<Response<T>> initObservable(Observable<Response<T>> observable, CommonCallback<T> callback) {
        return observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .doOnNext(callback::onResponse)
                .doOnError(callback::onError);
    }

    public static void getAllDetailMovie(String movieId,
                                         Observer<Object> observer,
                                         CommonCallback<GetDetailsResponse> getDetailsCallback,
                                         CommonCallback<GetVideosResponse> getVideoCallback,
                                         CommonCallback<GetListMoviesResponse> getSimilarCallback,
                                         CommonCallback<GetListMoviesResponse> getRecommendationsCallback) {
        List<Observable<?>> observableList = new ArrayList<>();

        observableList.add(getDetails(movieId, getDetailsCallback));
        observableList.add(getVideos(movieId, getVideoCallback));
        observableList.add(getSimilarMovies(movieId, getSimilarCallback));
        observableList.add(getRecommendationsMovies(movieId, getRecommendationsCallback));

        Observable.mergeDelayError(observableList)
                .observeOn(AndroidSchedulers.mainThread(), true)
                .subscribe(observer);
    }
}
