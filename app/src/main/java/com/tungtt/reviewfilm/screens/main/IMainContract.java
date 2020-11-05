package com.tungtt.reviewfilm.screens.main;

import com.tungtt.basemvp.mvp.model.IBaseModelLayer;
import com.tungtt.basemvp.mvp.presenter.IBasePresenterLayer;
import com.tungtt.basemvp.mvp.view.IBaseViewLayer;

/**
 * Created by tungtt a.k.a TungTT
 * On Thu, 05 Nov 2020 - 11:41
 */
public interface IMainContract {
    interface Model extends IBaseModelLayer<Presenter> {
        boolean isEven();
    }

    interface View extends IBaseViewLayer<Presenter> {
        void updateText(String text);
    }

    interface Presenter extends IBasePresenterLayer<View, Model> {
    }
}
