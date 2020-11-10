package com.tungtt.reviewfilm.screens.nowplaying;

import com.tungtt.basemvp.mvp.model.IBaseModelLayer;
import com.tungtt.basemvp.mvp.presenter.IBasePresenterLayer;
import com.tungtt.basemvp.mvp.view.IBaseViewLayer;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 11:45
 */
public interface INowPlayingContract {
    interface Model extends IBaseModelLayer<INowPlayingContract.Presenter> {
    }

    interface View extends IBaseViewLayer<INowPlayingContract.Presenter> {
    }

    interface Presenter extends IBasePresenterLayer<INowPlayingContract.View, INowPlayingContract.Model> {
    }
}
