package com.tungtt.reviewfilm.screens.main;

import android.util.Pair;

import androidx.fragment.app.Fragment;

import com.tungtt.basemvp.mvp.model.IBaseModelLayer;
import com.tungtt.basemvp.mvp.presenter.IBasePresenterLayer;
import com.tungtt.basemvp.mvp.view.IBaseViewLayer;
import com.tungtt.reviewfilm.network.CommonCallback;
import com.tungtt.reviewfilm.network.models.getlistmovies.response.GetListMoviesResponse;
import com.tungtt.reviewfilm.screens.main.adapters.TabMenuAdapter;

import java.util.List;

import io.reactivex.Observer;

/**
 * Created by tungtt a.k.a TungTT
 * On Thu, 05 Nov 2020 - 11:41
 */
public interface IMainContract {
    interface Model extends IBaseModelLayer<Presenter> {
        void getAllTabData(Observer<Object> observer,
                           CommonCallback<GetListMoviesResponse> upcomingCallback,
                           CommonCallback<GetListMoviesResponse> topRatedCallback,
                           CommonCallback<GetListMoviesResponse> popularCallback,
                           CommonCallback<GetListMoviesResponse> nowPlayingCallback);
    }

    interface View extends IBaseViewLayer<Presenter> {
    }

    interface Presenter extends IBasePresenterLayer<View, Model> {
        void callGetAllTabData();

        TabMenuAdapter initTabMenuAdapter(List<Pair<String, Fragment>> listFragments);

        String getName(int position);

        int getNameColor(boolean isTabSelected);

        int getIcon(int position, boolean isTabSelected);

        int getTextAppearance(boolean isCurrentTabSelected);
    }
}
