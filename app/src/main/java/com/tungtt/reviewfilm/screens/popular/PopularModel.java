package com.tungtt.reviewfilm.screens.popular;

import com.tungtt.basemvp.mvp.model.BaseModelLayer;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 11:45
 */
public class PopularModel extends BaseModelLayer<IPopularContract.Presenter>
        implements IPopularContract.Model {

    public static PopularModel newInstance() {
        return new PopularModel();
    }

    @Override
    public void init() {

    }
}
