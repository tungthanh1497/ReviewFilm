package com.tungtt.reviewfilm.screens.search;

import com.tungtt.basemvp.mvp.model.IBaseModelLayer;
import com.tungtt.basemvp.mvp.presenter.IBasePresenterLayer;
import com.tungtt.basemvp.mvp.view.IBaseViewLayer;
import com.tungtt.reviewfilm.network.CommonCallback;
import com.tungtt.reviewfilm.network.models.getlistmovies.response.GetListMoviesResponse;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 11:45
 */
public interface ISearchContract {
    interface Model extends IBaseModelLayer<ISearchContract.Presenter> {
        void searchMovies(String query, CommonCallback<GetListMoviesResponse> callback);
    }

    interface View extends IBaseViewLayer<ISearchContract.Presenter> {
    }

    interface Presenter extends IBasePresenterLayer<ISearchContract.View, ISearchContract.Model> {
        void searchMovies(String query);
    }
}
