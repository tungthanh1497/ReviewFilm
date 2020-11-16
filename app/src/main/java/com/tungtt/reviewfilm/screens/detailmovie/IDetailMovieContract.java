package com.tungtt.reviewfilm.screens.detailmovie;

import com.tungtt.basemvp.mvp.model.IBaseModelLayer;
import com.tungtt.basemvp.mvp.presenter.IBasePresenterLayer;
import com.tungtt.basemvp.mvp.view.IBaseViewLayer;
import com.tungtt.reviewfilm.network.CommonCallback;
import com.tungtt.reviewfilm.network.models.getdetails.GenreModel;
import com.tungtt.reviewfilm.network.models.getdetails.response.GetDetailsResponse;
import com.tungtt.reviewfilm.network.models.getlistmovies.MovieModel;
import com.tungtt.reviewfilm.network.models.getlistmovies.response.GetListMoviesResponse;
import com.tungtt.reviewfilm.network.models.getvideos.response.GetVideosResponse;

import java.util.List;

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

        void onGetDetailSuccess(GetDetailsResponse detailMovie);

        void onGetSuggestSuccess(List<MovieModel> results);
    }

    interface Presenter extends IBasePresenterLayer<IDetailMovieContract.View, IDetailMovieContract.Model> {
        void reload(String movieId);

        void getAllDetailMovie();

        String getGenresText(List<GenreModel> genres);
    }
}
