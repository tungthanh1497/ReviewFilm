package com.tungtt.reviewfilm.network;

import com.tungtt.reviewfilm.network.models.getdetails.response.GetDetailsResponse;
import com.tungtt.reviewfilm.network.models.getlistmovies.response.GetListMoviesResponse;
import com.tungtt.reviewfilm.network.models.getvideos.response.GetVideosResponse;
import com.tungtt.reviewfilm.network.models.searchkeywords.response.SearchKeyWordsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by tungtt a.k.a TungTT
 * On Mon, 09 Nov 2020 - 14:29
 */
public interface IApiService {
    @GET("movie/upcoming")
    Call<GetListMoviesResponse> getUpcoming();

    @GET("movie/top_rated")
    Call<GetListMoviesResponse> getTopRated();

    @GET("movie/popular")
    Call<GetListMoviesResponse> getPopular();

    @GET("movie/now_playing")
    Call<GetListMoviesResponse> getNowPlaying();

    @GET("movie/{movie_id}")
    Call<GetDetailsResponse> getDetails(@Path("movie_id") String movieId);

    @GET("movie/{movie_id}/videos")
    Call<GetVideosResponse> getVideos(@Path("movie_id") String movieId);

    @GET("movie/{movie_id}/similar")
    Call<GetListMoviesResponse> getSimilarMovies(@Path("movie_id") String movieId);

    @GET("movie/{movie_id}/recommendations")
    Call<GetListMoviesResponse> getRecommendationsMovies(@Path("movie_id") String movieId);

    @GET("search/keyword")
    Call<SearchKeyWordsResponse> searchKeywords(@Query("query") String query);
}
