package com.tungtt.reviewfilm.screens.tabcontent;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.tungtt.basemvp.BaseFragment;

public class TabContentFragment extends BaseFragment<ITabContentContract.View, ITabContentContract.Model>
        implements ITabContentContract.Presenter {
    @Override
    public void initViewModel() {
        initModelLayer(TabContentModel.newInstance());
        initViewLayer(TabContentView.newInstance());
    }

    @Override
    public void onReceiveData(@NonNull Bundle data) {

    }

    @Override
    public void init(View view) {

    }
}