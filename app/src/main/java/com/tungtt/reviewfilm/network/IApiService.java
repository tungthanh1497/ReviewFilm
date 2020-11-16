package com.tungtt.reviewfilm.network;

import com.tungtt.reviewfilm.network.models.getdetails.response.GetDetailsResponse;
import com.tungtt.reviewfilm.network.models.getlistmovies.response.GetListMoviesResponse;
import com.tungtt.reviewfilm.network.models.getvideos.response.GetVideosResponse;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by tungtt a.k.a TungTT
 * On Mon, 09 Nov 2020 - 14:29
 */
public interface IApiService {
    @GET("movie/upcoming")
    Observable<Response<GetListMoviesResponse>> getUpcoming();

    @GET("movie/top_rated")
    Observable<Response<GetListMoviesResponse>> getTopRated();

    @GET("movie/popular")
    Observable<Response<GetListMoviesResponse>> getPopular();

    @GET("movie/now_playing")
    Observable<Response<GetListMoviesResponse>> getNowPlaying();

    @GET("movie/{movie_id}")
    Observable<Response<GetDetailsResponse>> getDetails(@Path("movie_id") String movieId);

    @GET("movie/{movie_id}/videos")
    Observable<Response<GetVideosResponse>> getVideos(@Path("movie_id") String movieId);

    @GET("movie/{movie_id}/similar")
    Observable<Response<GetListMoviesResponse>> getSimilarMovies(@Path("movie_id") String movieId);

    @GET("movie/{movie_id}/recommendations")
    Observable<Response<GetListMoviesResponse>> getRecommendationsMovies(@Path("movie_id") String movieId);

    @GET("search/movie")
    Observable<Response<GetListMoviesResponse>> searchKeywords(@Query("query") String query);
}
