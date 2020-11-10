package com.tungtt.reviewfilm.screens.popular;

import com.tungtt.basemvp.mvp.model.IBaseModelLayer;
import com.tungtt.basemvp.mvp.presenter.IBasePresenterLayer;
import com.tungtt.basemvp.mvp.view.IBaseViewLayer;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 11:45
 */
public interface IPopularContract {
    interface Model extends IBaseModelLayer<IPopularContract.Presenter> {
    }

    interface View extends IBaseViewLayer<IPopularContract.Presenter> {
    }

    interface Presenter extends IBasePresenterLayer<IPopularContract.View, IPopularContract.Model> {
    }
}
