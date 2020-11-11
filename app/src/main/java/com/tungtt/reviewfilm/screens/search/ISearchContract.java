package com.tungtt.reviewfilm.screens.search;

import com.tungtt.basemvp.mvp.model.IBaseModelLayer;
import com.tungtt.basemvp.mvp.presenter.IBasePresenterLayer;
import com.tungtt.basemvp.mvp.view.IBaseViewLayer;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 11:45
 */
public interface ISearchContract {
    interface Model extends IBaseModelLayer<ISearchContract.Presenter> {
    }

    interface View extends IBaseViewLayer<ISearchContract.Presenter> {
    }

    interface Presenter extends IBasePresenterLayer<ISearchContract.View, ISearchContract.Model> {
    }
}
