package com.tungtt.reviewfilm.screens.home;

import com.tungtt.basemvp.mvp.model.IBaseModelLayer;
import com.tungtt.basemvp.mvp.presenter.IBasePresenterLayer;
import com.tungtt.basemvp.mvp.view.IBaseViewLayer;
import com.tungtt.reviewfilm.network.CommonCallback;
import com.tungtt.reviewfilm.network.models.getlistmovies.MovieModel;
import com.tungtt.reviewfilm.network.models.getlistmovies.response.GetListMoviesResponse;

import java.util.List;

import io.reactivex.Observer;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 11:45
 */
public interface IHomeContract {
    interface Model extends IBaseModelLayer<IHomeContract.Presenter> {
        void getAllData(Observer<Object> observer,
                        CommonCallback<GetListMoviesResponse> upcomingCallback,
                        CommonCallback<GetListMoviesResponse> topRatedCallback,
                        CommonCallback<GetListMoviesResponse> popularCallback,
                        CommonCallback<GetListMoviesResponse> nowPlayingCallback);
    }

    interface View extends IBaseViewLayer<IHomeContract.Presenter> {
        void onGetGroupMovieSuccess(String groupMovieName, List<MovieModel> listMovie);
    }

    interface Presenter extends IBasePresenterLayer<IHomeContract.View, IHomeContract.Model> {
        void getAllData();

        void moveToDetailMovie(MovieModel movieModel);
    }
}
