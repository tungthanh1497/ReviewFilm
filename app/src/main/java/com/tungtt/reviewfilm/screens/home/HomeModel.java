package com.tungtt.reviewfilm.screens.home;

import com.tungtt.basemvp.mvp.model.BaseModelLayer;

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
}
