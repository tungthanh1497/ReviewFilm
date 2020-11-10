package com.tungtt.reviewfilm.screens.toprated;

import android.view.View;

import com.tungtt.basemvp.mvp.view.BaseViewLayer;
import com.tungtt.reviewfilm.R;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 11:47
 */
public class TopRatedView extends BaseViewLayer<ITopRatedContract.Presenter>
        implements ITopRatedContract.View {

    public static TopRatedView newInstance() {
        return new TopRatedView();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_top_rated;
    }

    @Override
    public void bindViews(View view) {

    }

    @Override
    public void init() {

    }
}
