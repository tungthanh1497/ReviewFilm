package com.tungtt.reviewfilm.screens.detailmovie;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.tungtt.basemvp.BaseFragment;
import com.tungtt.reviewfilm.utils.ToastUtil;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class DetailMovieFragment extends BaseFragment<IDetailMovieContract.View, IDetailMovieContract.Model>
        implements IDetailMovieContract.Presenter {

    @Retention(RetentionPolicy.SOURCE)
    public @interface BUNDLE_TAG {
        String BUNDLE_MOVIE_ID = "bundle_movie_id";
    }

    private String movieId;

    public static DetailMovieFragment newInstance() {
        return new DetailMovieFragment();
    }

    @Override
    public void initViewModel() {
        initModelLayer(DetailMovieModel.newInstance());
        initViewLayer(DetailMovieView.newInstance());
    }

    @Override
    public void onReceiveData(@NonNull Bundle data) {
        movieId = data.getString(BUNDLE_TAG.BUNDLE_MOVIE_ID, "");
    }

    @Override
    public void init(View view) {
        ToastUtil.showToast(getContext(), movieId);
    }
}