package com.tungtt.reviewfilm.screens.upcoming;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.tungtt.basemvp.BaseFragment;

public class UpcomingFragment extends BaseFragment<IUpcomingContract.View, IUpcomingContract.Model>
        implements IUpcomingContract.Presenter {
    @Override
    public void initViewModel() {
        initModelLayer(UpcomingModel.newInstance());
        initViewLayer(UpcomingView.newInstance());
    }

    @Override
    public void onReceiveData(@NonNull Bundle data) {

    }

    @Override
    public void init(View view) {

    }
}