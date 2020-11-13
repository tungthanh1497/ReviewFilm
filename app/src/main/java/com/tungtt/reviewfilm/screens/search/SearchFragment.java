package com.tungtt.reviewfilm.screens.search;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.tungtt.basemvp.BaseFragment;
import com.tungtt.reviewfilm.screens.main.interfaces.OnMainListener;

public class SearchFragment extends BaseFragment<ISearchContract.View, ISearchContract.Model>
        implements ISearchContract.Presenter {

    private int mTabPosition;
    private OnMainListener mOnMainListener;

    public static SearchFragment newInstance(int tabPosition, OnMainListener listener) {
        return new SearchFragment(tabPosition, listener);
    }

    public SearchFragment(int tabPosition, OnMainListener listener) {
        this.mTabPosition = tabPosition;
        this.mOnMainListener = listener;
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

    @Override
    public void back() {
        if (mOnMainListener != null) {
            mOnMainListener.onBackPressed(mTabPosition);
        }
    }
}