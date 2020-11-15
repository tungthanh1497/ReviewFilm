package com.tungtt.reviewfilm.screens.detailmovie;

import com.tungtt.basemvp.mvp.model.IBaseModelLayer;
import com.tungtt.basemvp.mvp.presenter.IBasePresenterLayer;
import com.tungtt.basemvp.mvp.view.IBaseViewLayer;
import com.tungtt.reviewfilm.network.CommonCallback;
import com.tungtt.reviewfilm.network.models.getdetails.response.GetDetailsResponse;
import com.tungtt.reviewfilm.network.models.getlistmovies.response.GetListMoviesResponse;
import com.tungtt.reviewfilm.network.models.getvideos.response.GetVideosResponse;

import io.reactivex.Observer;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 11:45
 */
public interface IDetailMovieContract {
    interface Model extends IBaseModelLayer<IDetailMovieContract.Presenter> {
        void getAllDetailMovie(String movieId,
                               Observer<Object> observer,
                               CommonCallback<GetDetailsResponse> getDetailsCallback,
                               CommonCallback<GetVideosResponse> getVideoCallback,
                               CommonCallback<GetListMoviesResponse> getSimilarCallback,
                               CommonCallback<GetListMoviesResponse> getRecommendationsCallback);
    }

    interface View extends IBaseViewLayer<IDetailMovieContract.Presenter> {
        void onGetVideoSuccess(String videoKey);
    }

    interface Presenter extends IBasePresenterLayer<IDetailMovieContract.View, IDetailMovieContract.Model> {
        String getMovieKey();
    }
}
