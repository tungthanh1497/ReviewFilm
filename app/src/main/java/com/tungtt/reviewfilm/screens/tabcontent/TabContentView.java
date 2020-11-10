package com.tungtt.reviewfilm.screens.tabcontent;

import android.view.View;

import com.tungtt.basemvp.mvp.view.BaseViewLayer;
import com.tungtt.reviewfilm.R;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 11:47
 */
public class TabContentView extends BaseViewLayer<ITabContentContract.Presenter>
        implements ITabContentContract.View {

    public static TabContentView newInstance() {
        return new TabContentView();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_tab_content;
    }

    @Override
    public void bindViews(View view) {

    }

    @Override
    public void init() {

    }
}
