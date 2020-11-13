package com.tungtt.reviewfilm.screens.detailmovie;

import com.tungtt.basemvp.mvp.model.IBaseModelLayer;
import com.tungtt.basemvp.mvp.presenter.IBasePresenterLayer;
import com.tungtt.basemvp.mvp.view.IBaseViewLayer;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 11:45
 */
public interface IDetailMovieContract {
    interface Model extends IBaseModelLayer<IDetailMovieContract.Presenter> {
    }

    interface View extends IBaseViewLayer<IDetailMovieContract.Presenter> {
    }

    interface Presenter extends IBasePresenterLayer<IDetailMovieContract.View, IDetailMovieContract.Model> {
    }
}
