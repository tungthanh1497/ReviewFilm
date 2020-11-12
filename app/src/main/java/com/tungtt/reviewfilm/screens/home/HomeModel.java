package com.tungtt.reviewfilm.screens.home;

import com.tungtt.basemvp.mvp.model.BaseModelLayer;
import com.tungtt.reviewfilm.network.CommonCallback;
import com.tungtt.reviewfilm.network.NetworkController;
import com.tungtt.reviewfilm.network.models.getlistmovies.response.GetListMoviesResponse;

import io.reactivex.Observer;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 11:45
 */
public class HomeModel extends BaseModelLayer<IHomeContract.Presenter>
        implements IHomeContract.Model {

    public static HomeModel newInstance() {
        return new HomeModel();
    }

    @Override
    public void init() {

    }

    @Override
    public void getAllData(Observer<Object> observer,
                           CommonCallback<GetListMoviesResponse> upcomingCallback,
                           CommonCallback<GetListMoviesResponse> topRatedCallback,
                           CommonCallback<GetListMoviesResponse> popularCallback,
                           CommonCallback<GetListMoviesResponse> nowPlayingCallback) {
        NetworkController.getAllTabData(observer, upcomingCallback, topRatedCallback, popularCallback, nowPlayingCallback);
    }
}
