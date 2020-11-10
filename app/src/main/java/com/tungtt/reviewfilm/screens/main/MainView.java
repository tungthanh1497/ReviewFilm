package com.tungtt.reviewfilm.screens.main;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.tungtt.basemvp.mvp.view.BaseViewLayer;
import com.tungtt.reviewfilm.R;
import com.tungtt.reviewfilm.network.models.getlistmovies.response.GetListMoviesResponse;

/**
 * Created by tungtt a.k.a TungTT
 * On Thu, 05 Nov 2020 - 11:55
 */
public class MainView extends BaseViewLayer<IMainContract.Presenter>
        implements IMainContract.View {

    private static final String TAG = MainView.class.getSimpleName();

    TextView tv;

    public static MainView newInstance() {
        return new MainView();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.main_fragment;
    }

    @Override
    public void bindViews(View view) {
        tv = view.findViewById(R.id.message);
    }

    @Override
    public void init() {
        implementListeners();
    }

    @Override
    public void getUpcomingSuccess(GetListMoviesResponse response) {
        Log.w(TAG, "getUpcomingSuccess: " + response);
    }

    @Override
    public void getUpcomingError() {
        Log.e(TAG, "getUpcomingError: ");
    }

    private void implementListeners() {
        tv.setOnClickListener(v -> mPresenter().onTvClicked());
    }
}
