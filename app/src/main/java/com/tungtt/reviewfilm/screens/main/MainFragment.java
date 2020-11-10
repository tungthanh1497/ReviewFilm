package com.tungtt.reviewfilm.screens.main;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.tungtt.basemvp.BaseFragment;
import com.tungtt.reviewfilm.network.CommonCallback;
import com.tungtt.reviewfilm.network.models.getlistmovies.response.GetListMoviesResponse;

/**
 * Created by tungtt a.k.a TungTT
 * On Thu, 05 Nov 2020 - 11:54
 */
public class MainFragment extends BaseFragment<IMainContract.View, IMainContract.Model>
        implements IMainContract.Presenter {

    private static final String TAG = MainFragment.class.toString();

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void initViewModel() {
        initModelLayer(MainModel.newInstance());
        initViewLayer(MainView.newInstance());
    }

    @Override
    public void onReceiveData(@NonNull Bundle data) {

    }

    @Override
    public void init(View view) {
        onTvClicked();
    }

    @Override
    public void onTvClicked() {
        mModel().getUpcoming(new CommonCallback<GetListMoviesResponse>(getActivity()) {
            @Override
            public void onCommonSuccess(GetListMoviesResponse response) {
                super.onCommonSuccess(response);
                mView().getUpcomingSuccess(response);
            }

            @Override
            public void onCommonError(GetListMoviesResponse response) {
                super.onCommonError(response);
                mView().getUpcomingError();
            }
        });
    }
}
