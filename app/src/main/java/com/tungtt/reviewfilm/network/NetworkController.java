package com.tungtt.reviewfilm.network;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.tungtt.reviewfilm.network.models.getdetails.response.GetDetailsResponse;
import com.tungtt.reviewfilm.network.models.getlistmovies.response.GetListMoviesResponse;
import com.tungtt.reviewfilm.network.models.getvideos.response.GetVideosResponse;
import com.tungtt.reviewfilm.network.models.searchkeywords.response.SearchKeyWordsResponse;

import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Callback;
import retrofit2.Retrofit;
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
                    .client(builder.build())
                    .build();
            mApiBuilder = retrofit.create(IApiService.class);
        }
        return mApiBuilder;
    }

    public static void getUpcoming(Callback<GetListMoviesResponse> callback) {
        getAPIBuilder().getUpcoming().enqueue(callback);
    }

    public static void getTopRated(Callback<GetListMoviesResponse> callback) {
        getAPIBuilder().getTopRated().enqueue(callback);
    }

    public static void getPopular(Callback<GetListMoviesResponse> callback) {
        getAPIBuilder().getPopular().enqueue(callback);
    }

    public static void getNowPlaying(Callback<GetListMoviesResponse> callback) {
        getAPIBuilder().getNowPlaying().enqueue(callback);
    }

    public static void getDetails(String movieId,
                                  Callback<GetDetailsResponse> callback) {
        getAPIBuilder().getDetails(movieId).enqueue(callback);
    }

    public static void getVideos(String movieId,
                                 Callback<GetVideosResponse> callback) {
        getAPIBuilder().getVideos(movieId).enqueue(callback);
    }

    public static void getSimilarMovies(String movieId,
                                        Callback<GetListMoviesResponse> callback) {
        getAPIBuilder().getSimilarMovies(movieId).enqueue(callback);
    }

    public static void getRecommendationsMovies(String movieId,
                                                Callback<GetListMoviesResponse> callback) {
        getAPIBuilder().getRecommendationsMovies(movieId).enqueue(callback);
    }

    public static void searchKeywords(String query,
                                      Callback<SearchKeyWordsResponse> callback) {
        getAPIBuilder().searchKeywords(query).enqueue(callback);
    }
}
