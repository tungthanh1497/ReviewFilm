package com.tungtt.reviewfilm.screens.popular;

import android.view.View;

import com.tungtt.basemvp.mvp.view.BaseViewLayer;
import com.tungtt.reviewfilm.R;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 11:47
 */
public class PopularView extends BaseViewLayer<IPopularContract.Presenter>
        implements IPopularContract.View {

    public static PopularView newInstance() {
        return new PopularView();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_popular;
    }

    @Override
    public void bindViews(View view) {

    }

    @Override
    public void init() {

    }
}
