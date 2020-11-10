package com.tungtt.reviewfilm.screens.popular;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.tungtt.basemvp.BaseFragment;

public class PopularFragment extends BaseFragment<IPopularContract.View, IPopularContract.Model>
        implements IPopularContract.Presenter {
    @Override
    public void initViewModel() {
        initModelLayer(PopularModel.newInstance());
        initViewLayer(PopularView.newInstance());
    }

    @Override
    public void onReceiveData(@NonNull Bundle data) {

    }

    @Override
    public void init(View view) {

    }
}