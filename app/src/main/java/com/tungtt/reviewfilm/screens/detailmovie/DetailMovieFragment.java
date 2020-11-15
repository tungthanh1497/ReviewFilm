package com.tungtt.reviewfilm.screens.detailmovie;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.annotation.NonNull;

import com.tungtt.basemvp.BaseFragment;
import com.tungtt.reviewfilm.network.CommonCallback;
import com.tungtt.reviewfilm.network.models.getdetails.response.GetDetailsResponse;
import com.tungtt.reviewfilm.network.models.getlistmovies.response.GetListMoviesResponse;
import com.tungtt.reviewfilm.network.models.getvideos.response.GetVideosResponse;
import com.tungtt.reviewfilm.utils.ActivityUtil;
import com.tungtt.reviewfilm.utils.CommonUtil;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

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
        mModel().getAllDetailMovie(movieId,
                getAllDetailMovieCallback(),
                getDetailsCallback(),
                getVideoCallback(),
                getSimilarCallback(),
                getRecommendationsCallback());
    }

    @Override
    public String getMovieKey() {
        return "cW9EdTbkWfc";
    }

    private Observer<Object> getAllDetailMovieCallback() {
        return new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {
                ActivityUtil.showProgressDialog(getActivity());
            }

            @Override
            public void onNext(Object o) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                new Handler().postDelayed(() -> {
                    ActivityUtil.dismissProgressDialog(getActivity());
                }, 3000);
            }
        };
    }

    private CommonCallback<GetDetailsResponse> getDetailsCallback() {
        return new CommonCallback<GetDetailsResponse>(getActivity()) {
            @Override
            public void onCommonSuccess(GetDetailsResponse response) {
                super.onCommonSuccess(response);
            }

            @Override
            public void onCommonError(GetDetailsResponse response) {
                super.onCommonError(response);
            }
        };
    }

    private CommonCallback<GetVideosResponse> getVideoCallback() {
        return new CommonCallback<GetVideosResponse>(getActivity()) {
            @Override
            public void onCommonSuccess(GetVideosResponse response) {
                super.onCommonSuccess(response);
                if (!CommonUtil.isNullOrEmpty(response.getResults())
                        && response.getResults().get(0) != null) {
                    mView().onGetVideoSuccess(response.getResults().get(0).getKey());
                }
            }

            @Override
            public void onCommonError(GetVideosResponse response) {
                super.onCommonError(response);
            }
        };
    }

    private CommonCallback<GetListMoviesResponse> getSimilarCallback() {
        return new CommonCallback<GetListMoviesResponse>(getActivity()) {
            @Override
            public void onCommonSuccess(GetListMoviesResponse response) {
                super.onCommonSuccess(response);
            }

            @Override
            public void onCommonError(GetListMoviesResponse response) {
                super.onCommonError(response);
            }
        };
    }

    private CommonCallback<GetListMoviesResponse> getRecommendationsCallback() {
        return new CommonCallback<GetListMoviesResponse>(getActivity()) {
            @Override
            public void onCommonSuccess(GetListMoviesResponse response) {
                super.onCommonSuccess(response);
            }

            @Override
            public void onCommonError(GetListMoviesResponse response) {
                super.onCommonError(response);
            }
        };
    }
}