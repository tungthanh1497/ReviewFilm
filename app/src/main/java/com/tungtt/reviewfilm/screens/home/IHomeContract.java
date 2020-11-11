package com.tungtt.reviewfilm.screens.home;

import com.tungtt.basemvp.mvp.model.IBaseModelLayer;
import com.tungtt.basemvp.mvp.presenter.IBasePresenterLayer;
import com.tungtt.basemvp.mvp.view.IBaseViewLayer;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 11:45
 */
public interface IHomeContract {
    interface Model extends IBaseModelLayer<IHomeContract.Presenter> {
    }

    interface View extends IBaseViewLayer<IHomeContract.Presenter> {
    }

    interface Presenter extends IBasePresenterLayer<IHomeContract.View, IHomeContract.Model> {
    }
}
