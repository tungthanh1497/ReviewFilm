package com.tungtt.reviewfilm.screens.home;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.annotation.NonNull;

import com.tungtt.basemvp.BaseFragment;
import com.tungtt.reviewfilm.network.CommonCallback;
import com.tungtt.reviewfilm.network.models.getlistmovies.MovieModel;
import com.tungtt.reviewfilm.network.models.getlistmovies.response.GetListMoviesResponse;
import com.tungtt.reviewfilm.screens.detailmovie.DetailMovieFragment;
import com.tungtt.reviewfilm.screens.main.interfaces.OnMainListener;
import com.tungtt.reviewfilm.utils.ActivityUtil;
import com.tungtt.reviewfilm.utils.Constant;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class HomeFragment extends BaseFragment<IHomeContract.View, IHomeContract.Model>
        implements IHomeContract.Presenter {

    @Retention(RetentionPolicy.SOURCE)
    private @interface GROUP_MOVIE_NAME {
        String UPCOMING = "Upcoming";
        String TOP_RATED = "Top rated";
        String POPULAR = "Popular";
        String NOW_PLAYING = "Now Playing";
    }

    private int mTabPosition;
    private OnMainListener mOnMainListener;

    public static HomeFragment newInstance(int tabPosition, OnMainListener listener) {
        return new HomeFragment(tabPosition, listener);
    }

    public HomeFragment(int tabPosition, OnMainListener mOnMainListener) {
        this.mTabPosition = tabPosition;
        this.mOnMainListener = mOnMainListener;
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

    @Override
    public void getAllData() {
        mModel().getAllData(getAllDataCallBack(),
                getGroupMovieCallBack(GROUP_MOVIE_NAME.UPCOMING),
                getGroupMovieCallBack(GROUP_MOVIE_NAME.TOP_RATED),
                getGroupMovieCallBack(GROUP_MOVIE_NAME.POPULAR),
                getGroupMovieCallBack(GROUP_MOVIE_NAME.NOW_PLAYING));
    }

    private CommonCallback<GetListMoviesResponse> getGroupMovieCallBack(@GROUP_MOVIE_NAME String groupMovieName) {
        return new CommonCallback<GetListMoviesResponse>(getActivity()) {
            @Override
            public void onCommonSuccess(GetListMoviesResponse response) {
                super.onCommonSuccess(response);
                mView().onGetGroupMovieSuccess(groupMovieName, response.getResults());
            }

            @Override
            public void onCommonError(GetListMoviesResponse response) {
                super.onCommonError(response);
            }
        };
    }

    private Observer<Object> getAllDataCallBack() {
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
                    mView().onLoadAllDataSuccess();
                }, 3000);
            }
        };
    }

    @Override
    public void back() {
        if (mOnMainListener != null) {
            mOnMainListener.onBackPressed(mTabPosition);
        }
    }

    @Override
    public void moveToDetailMovie(MovieModel movieModel) {
        Bundle bundle = new Bundle();
        bundle.putString(DetailMovieFragment.BUNDLE_TAG.BUNDLE_MOVIE_ID, movieModel.getId());
        ActivityUtil.addScreen(DetailMovieFragment.newInstance(), Constant.SCREEN_TAG.DETAIL_MOVIE, bundle);
    }
}