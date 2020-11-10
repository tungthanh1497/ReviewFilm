package com.tungtt.reviewfilm.screens.upcoming;

import com.tungtt.basemvp.mvp.model.BaseModelLayer;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 11:45
 */
public class UpcomingModel extends BaseModelLayer<IUpcomingContract.Presenter>
        implements IUpcomingContract.Model {

    public static UpcomingModel newInstance() {
        return new UpcomingModel();
    }

    @Override
    public void init() {

    }
}
