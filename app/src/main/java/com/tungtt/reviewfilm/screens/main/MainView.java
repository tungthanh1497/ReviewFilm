package com.tungtt.reviewfilm.screens.main;

import android.view.View;
import android.widget.TextView;

import com.tungtt.basemvp.mvp.view.BaseViewLayer;
import com.tungtt.reviewfilm.R;

/**
 * Created by tungtt a.k.a TungTT
 * On Thu, 05 Nov 2020 - 11:55
 */
public class MainView extends BaseViewLayer<IMainContract.Presenter>
        implements IMainContract.View {

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
    public void updateText(String text) {
        tv.setText(text);
    }
}
