package com.tungtt.reviewfilm.screens.upcoming;

import android.view.View;

import com.tungtt.basemvp.mvp.view.BaseViewLayer;
import com.tungtt.reviewfilm.R;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 11:47
 */
public class UpcomingView extends BaseViewLayer<IUpcomingContract.Presenter>
        implements IUpcomingContract.View {

    public static UpcomingView newInstance() {
        return new UpcomingView();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_upcoming;
    }

    @Override
    public void bindViews(View view) {

    }

    @Override
    public void init() {

    }
}
