package com.tungtt.reviewfilm.screens.toprated;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.tungtt.basemvp.BaseFragment;

public class TopRatedFragment extends BaseFragment<ITopRatedContract.View, ITopRatedContract.Model>
        implements ITopRatedContract.Presenter {
    @Override
    public void initViewModel() {
        initModelLayer(TopRatedModel.newInstance());
        initViewLayer(TopRatedView.newInstance());
    }

    @Override
    public void onReceiveData(@NonNull Bundle data) {

    }

    @Override
    public void init(View view) {

    }
}