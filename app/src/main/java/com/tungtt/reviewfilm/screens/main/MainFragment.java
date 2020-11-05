package com.tungtt.reviewfilm.screens.main;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.tungtt.basemvp.BaseFragment;

/**
 * Created by tungtt a.k.a TungTT
 * On Thu, 05 Nov 2020 - 11:54
 */
public class MainFragment extends BaseFragment<IMainContract.View, IMainContract.Model>
        implements IMainContract.Presenter {

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void initViewModel() {
        initModelLayer(MainModel.newInstance());
        initViewLayer(MainView.newInstance());
    }

    @Override
    public void onReceiveData(@NonNull Bundle data) {

    }

    @Override
    public void init(View view) {
        if (mModel().isEven()) {
            mView().updateText("Even");
        } else {
            mView().updateText("Odd");
        }
    }
}
