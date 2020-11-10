package com.tungtt.reviewfilm.screens.toprated;

import com.tungtt.basemvp.mvp.model.BaseModelLayer;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 11:45
 */
public class TopRatedModel extends BaseModelLayer<ITopRatedContract.Presenter>
        implements ITopRatedContract.Model {

    public static TopRatedModel newInstance() {
        return new TopRatedModel();
    }

    @Override
    public void init() {

    }
}
