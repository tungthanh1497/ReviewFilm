package com.tungtt.reviewfilm.screens.search;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.tungtt.basemvp.BaseFragment;
import com.tungtt.reviewfilm.network.CommonCallback;
import com.tungtt.reviewfilm.network.models.getlistmovies.MovieModel;
import com.tungtt.reviewfilm.network.models.getlistmovies.response.GetListMoviesResponse;
import com.tungtt.reviewfilm.screens.detailmovie.DetailMovieFragment;
import com.tungtt.reviewfilm.screens.main.interfaces.OnMainListener;
import com.tungtt.reviewfilm.utils.ActivityUtil;
import com.tungtt.reviewfilm.utils.CommonUtil;
import com.tungtt.reviewfilm.utils.Constant;

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

    @Override
    public void searchMovies(String query) {
        ActivityUtil.showProgressDialog(getActivity());
        mModel().searchMovies(query,
                new CommonCallback<GetListMoviesResponse>(getActivity()) {
                    @Override
                    public void onCommonSuccess(GetListMoviesResponse response) {
                        super.onCommonSuccess(response);
                        if (!CommonUtil.isNullOrEmpty(response.getResults())) {
                            mView().onSearchSuccess(response.getResults());
                        }
                        ActivityUtil.dismissProgressDialog(getActivity());
                    }

                    @Override
                    public void onCommonError(GetListMoviesResponse response) {
                        super.onCommonError(response);
                        ActivityUtil.dismissProgressDialog(getActivity());
                    }
                });
    }

    @Override
    public void moveToDetailMovie(MovieModel movieModel) {
        Bundle bundle = new Bundle();
        bundle.putString(DetailMovieFragment.BUNDLE_TAG.BUNDLE_MOVIE_ID, movieModel.getId());
        ActivityUtil.addScreen(DetailMovieFragment.newInstance(), Constant.SCREEN_TAG.DETAIL_MOVIE, bundle);
    }
}