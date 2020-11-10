package com.tungtt.reviewfilm.screens.main;

import android.view.View;

import com.tungtt.basemvp.mvp.view.BaseViewLayer;
import com.tungtt.reviewfilm.R;

/**
 * Created by tungtt a.k.a TungTT
 * On Thu, 05 Nov 2020 - 11:55
 */
public class MainView extends BaseViewLayer<IMainContract.Presenter>
        implements IMainContract.View {

    private static final String TAG = MainView.class.getSimpleName();

    public static MainView newInstance() {
        return new MainView();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.main_fragment;
    }

    @Override
    public void bindViews(View view) {
    }

    @Override
    public void init() {
        implementListeners();
    }

    private void implementListeners() {
    }
}
