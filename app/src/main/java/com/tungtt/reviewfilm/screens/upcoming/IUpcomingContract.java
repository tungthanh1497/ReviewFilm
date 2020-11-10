package com.tungtt.reviewfilm.screens.upcoming;

import com.tungtt.basemvp.mvp.model.IBaseModelLayer;
import com.tungtt.basemvp.mvp.presenter.IBasePresenterLayer;
import com.tungtt.basemvp.mvp.view.IBaseViewLayer;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 11:45
 */
public interface IUpcomingContract {
    interface Model extends IBaseModelLayer<IUpcomingContract.Presenter> {
    }

    interface View extends IBaseViewLayer<IUpcomingContract.Presenter> {
    }

    interface Presenter extends IBasePresenterLayer<IUpcomingContract.View, IUpcomingContract.Model> {
    }
}
