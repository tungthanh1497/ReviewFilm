package com.tungtt.reviewfilm.screens.toprated;

import com.tungtt.basemvp.mvp.model.IBaseModelLayer;
import com.tungtt.basemvp.mvp.presenter.IBasePresenterLayer;
import com.tungtt.basemvp.mvp.view.IBaseViewLayer;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 11:45
 */
public interface ITopRatedContract {
    interface Model extends IBaseModelLayer<ITopRatedContract.Presenter> {
    }

    interface View extends IBaseViewLayer<ITopRatedContract.Presenter> {
    }

    interface Presenter extends IBasePresenterLayer<ITopRatedContract.View, ITopRatedContract.Model> {
    }
}
