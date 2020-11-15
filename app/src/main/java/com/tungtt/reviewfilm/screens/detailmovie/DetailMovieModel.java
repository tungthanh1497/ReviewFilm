package com.tungtt.reviewfilm.screens.detailmovie;

import com.tungtt.basemvp.mvp.model.BaseModelLayer;
import com.tungtt.reviewfilm.network.CommonCallback;
import com.tungtt.reviewfilm.network.NetworkController;
import com.tungtt.reviewfilm.network.models.getdetails.response.GetDetailsResponse;
import com.tungtt.reviewfilm.network.models.getlistmovies.response.GetListMoviesResponse;
import com.tungtt.reviewfilm.network.models.getvideos.response.GetVideosResponse;

import io.reactivex.Observer;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 11:45
 */
public class DetailMovieModel extends BaseModelLayer<IDetailMovieContract.Presenter>
        implements IDetailMovieContract.Model {

    public static DetailMovieModel newInstance() {
        return new DetailMovieModel();
    }

    @Override
    public void init() {

    }

    @Override
    public void getAllDetailMovie(String movieId,
                                  Observer<Object> observer,
                                  CommonCallback<GetDetailsResponse> getDetailsCallback,
                                  CommonCallback<GetVideosResponse> getVideoCallback,
                                  CommonCallback<GetListMoviesResponse> getSimilarCallback,
                                  CommonCallback<GetListMoviesResponse> getRecommendationsCallback) {
        NetworkController.getAllDetailMovie(movieId,
                observer,
                getDetailsCallback,
                getVideoCallback,
                getSimilarCallback,
                getRecommendationsCallback);
    }
}
