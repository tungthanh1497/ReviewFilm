package com.tungtt.reviewfilm.screens.nowplaying;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.tungtt.basemvp.BaseFragment;

public class NowPlayingFragment extends BaseFragment<INowPlayingContract.View, INowPlayingContract.Model>
        implements INowPlayingContract.Presenter {
    @Override
    public void initViewModel() {
        initModelLayer(NowPlayingModel.newInstance());
        initViewLayer(NowPlayingView.newInstance());
    }

    @Override
    public void onReceiveData(@NonNull Bundle data) {

    }

    @Override
    public void init(View view) {

    }
}