package com.tungtt.reviewfilm.screens.search;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.tungtt.basemvp.BaseFragment;

public class SearchFragment extends BaseFragment<ISearchContract.View, ISearchContract.Model>
        implements ISearchContract.Presenter {

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    public void initViewModel() {
        initModelLayer(SearchModel.newInstance());
        initViewLayer(SearchView.newInstance());
    }

    @Override
    public void onReceiveData(@NonNull Bundle data) {

    }

    @Override
    public void init(View view) {

    }
}