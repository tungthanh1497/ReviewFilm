package com.tungtt.reviewfilm.screens.search;

import android.view.View;

import com.tungtt.basemvp.mvp.view.BaseViewLayer;
import com.tungtt.reviewfilm.R;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 11:47
 */
public class SearchView extends BaseViewLayer<ISearchContract.Presenter>
        implements ISearchContract.View {

    public static SearchView newInstance() {
        return new SearchView();
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
