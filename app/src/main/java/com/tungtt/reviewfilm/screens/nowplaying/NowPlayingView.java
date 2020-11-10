package com.tungtt.reviewfilm.screens.nowplaying;

import android.view.View;

import com.tungtt.basemvp.mvp.view.BaseViewLayer;
import com.tungtt.reviewfilm.R;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 11:47
 */
public class NowPlayingView extends BaseViewLayer<INowPlayingContract.Presenter>
        implements INowPlayingContract.View {

    public static NowPlayingView newInstance() {
        return new NowPlayingView();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_now_playing;
    }

    @Override
    public void bindViews(View view) {

    }

    @Override
    public void init() {

    }
}
