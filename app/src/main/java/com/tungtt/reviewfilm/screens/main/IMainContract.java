package com.tungtt.reviewfilm.screens.main;

import com.tungtt.basemvp.mvp.model.IBaseModelLayer;
import com.tungtt.basemvp.mvp.presenter.IBasePresenterLayer;
import com.tungtt.basemvp.mvp.view.IBaseViewLayer;
import com.tungtt.reviewfilm.network.CommonCallback;
import com.tungtt.reviewfilm.network.models.getlistmovies.response.GetListMoviesResponse;

import io.reactivex.Observer;

/**
 * Created by tungtt a.k.a TungTT
 * On Thu, 05 Nov 2020 - 11:41
 */
public interface IMainContract {
    interface Model extends IBaseModelLayer<Presenter> {
        void getAllTabData(Observer<Object> observer,
                           CommonCallback<GetListMoviesResponse> upcomingCallback,
                           CommonCallback<GetListMoviesResponse> topRatedCallback,
                           CommonCallback<GetListMoviesResponse> popularCallback,
                           CommonCallback<GetListMoviesResponse> nowPlayingCallback);
    }

    interface View extends IBaseViewLayer<Presenter> {
    }

    interface Presenter extends IBasePresenterLayer<View, Model> {
        void callGetAllTabData();
    }
}
