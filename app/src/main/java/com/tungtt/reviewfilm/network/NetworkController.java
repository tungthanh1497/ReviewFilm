package com.tungtt.reviewfilm.network;

import com.tungtt.reviewfilm.network.models.getdetails.response.GetDetailsResponse;
import com.tungtt.reviewfilm.network.models.getlistmovies.response.GetListMoviesResponse;
import com.tungtt.reviewfilm.network.models.getvideos.response.GetVideosResponse;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by tungtt a.k.a TungTT
 * On Mon, 09 Nov 2020 - 14:30
 */
public class NetworkController {

    public static void searchMovies(String query,
                                    CommonCallback<GetListMoviesResponse> callback) {
        NetworkFactory.searchMovies(query, callback).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    public static void getAllTabData(Observer<Object> observer,
                                     CommonCallback<GetListMoviesResponse> upcomingCallback,
                                     CommonCallback<GetListMoviesResponse> topRatedCallback,
                                     CommonCallback<GetListMoviesResponse> popularCallback,
                                     CommonCallback<GetListMoviesResponse> nowPlayingCallback) {
        List<Observable<?>> observableList = new ArrayList<>();

        observableList.add(NetworkFactory.getUpcoming(upcomingCallback));
        observableList.add(NetworkFactory.getTopRated(topRatedCallback));
        observableList.add(NetworkFactory.getPopular(popularCallback));
        observableList.add(NetworkFactory.getNowPlaying(nowPlayingCallback));

        Observable.mergeDelayError(observableList)
                .observeOn(AndroidSchedulers.mainThread(), true)
                .subscribe(observer);
    }

    public static void getAllDetailMovie(String movieId,
                                         Observer<Object> observer,
                                         CommonCallback<GetDetailsResponse> getDetailsCallback,
                                         CommonCallback<GetVideosResponse> getVideoCallback,
                                         CommonCallback<GetListMoviesResponse> getSimilarCallback,
                                         CommonCallback<GetListMoviesResponse> getRecommendationsCallback) {
        List<Observable<?>> observableList = new ArrayList<>();

        observableList.add(NetworkFactory.getDetails(movieId, getDetailsCallback));
        observableList.add(NetworkFactory.getVideos(movieId, getVideoCallback));
        observableList.add(NetworkFactory.getSimilarMovies(movieId, getSimilarCallback));
        observableList.add(NetworkFactory.getRecommendationsMovies(movieId, getRecommendationsCallback));

        Observable.mergeDelayError(observableList)
                .observeOn(AndroidSchedulers.mainThread(), true)
                .subscribe(observer);
    }
}
