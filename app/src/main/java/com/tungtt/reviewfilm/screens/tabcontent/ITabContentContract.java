package com.tungtt.reviewfilm.screens.tabcontent;

import com.tungtt.basemvp.mvp.model.IBaseModelLayer;
import com.tungtt.basemvp.mvp.presenter.IBasePresenterLayer;
import com.tungtt.basemvp.mvp.view.IBaseViewLayer;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 11:45
 */
public interface ITabContentContract {
    interface Model extends IBaseModelLayer<ITabContentContract.Presenter> {
    }

    interface View extends IBaseViewLayer<ITabContentContract.Presenter> {
    }

    interface Presenter extends IBasePresenterLayer<ITabContentContract.View, ITabContentContract.Model> {
    }
}
