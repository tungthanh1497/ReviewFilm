package com.tungtt.reviewfilm.screens.home;

import android.view.View;

import com.tungtt.basemvp.mvp.view.BaseViewLayer;
import com.tungtt.reviewfilm.R;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 11:47
 */
public class HomeView extends BaseViewLayer<IHomeContract.Presenter>
        implements IHomeContract.View {

    public static HomeView newInstance() {
        return new HomeView();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    public void bindViews(View view) {

    }

    @Override
    public void init() {

    }
}
