package com.tungtt.reviewfilm.screens.home;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.tungtt.basemvp.BaseFragment;

public class HomeFragment extends BaseFragment<IHomeContract.View, IHomeContract.Model>
        implements IHomeContract.Presenter {

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void initViewModel() {
        initModelLayer(HomeModel.newInstance());
        initViewLayer(HomeView.newInstance());
    }

    @Override
    public void onReceiveData(@NonNull Bundle data) {

    }

    @Override
    public void init(View view) {

    }
}