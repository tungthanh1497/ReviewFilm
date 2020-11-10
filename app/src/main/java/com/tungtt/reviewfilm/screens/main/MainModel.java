package com.tungtt.reviewfilm.screens.main;

import com.tungtt.basemvp.mvp.model.BaseModelLayer;
import com.tungtt.reviewfilm.network.CommonCallback;
import com.tungtt.reviewfilm.network.NetworkController;
import com.tungtt.reviewfilm.network.models.getlistmovies.response.GetListMoviesResponse;

/**
 * Created by tungtt a.k.a TungTT
 * On Thu, 05 Nov 2020 - 11:58
 */
public class MainModel extends BaseModelLayer<IMainContract.Presenter>
        implements IMainContract.Model {

    public static MainModel newInstance() {
        return new MainModel();
    }

    @Override
    public void init() {

    }

    @Override
    public void getUpcoming(CommonCallback<GetListMoviesResponse> callback) {
        NetworkController.getUpcoming(callback).subscribe();
    }
}
