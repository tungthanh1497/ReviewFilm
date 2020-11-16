package com.tungtt.reviewfilm.screens.detailmovie;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.tungtt.basemvp.BaseFragment;
import com.tungtt.reviewfilm.network.CommonCallback;
import com.tungtt.reviewfilm.network.models.getdetails.GenreModel;
import com.tungtt.reviewfilm.network.models.getdetails.response.GetDetailsResponse;
import com.tungtt.reviewfilm.network.models.getlistmovies.response.GetListMoviesResponse;
import com.tungtt.reviewfilm.network.models.getvideos.response.GetVideosResponse;
import com.tungtt.reviewfilm.utils.ActivityUtil;
import com.tungtt.reviewfilm.utils.CommonUtil;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class DetailMovieFragment extends BaseFragment<IDetailMovieContract.View, IDetailMovieContract.Model>
        implements IDetailMovieContract.Presenter {

    @Retention(RetentionPolicy.SOURCE)
    public @interface BUNDLE_TAG {
        String BUNDLE_MOVIE_ID = "bundle_movie_id";
    }

    private String mMovieId;

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
        mMovieId = data.getString(BUNDLE_TAG.BUNDLE_MOVIE_ID, "");
    }

    @Override
    public void init(View view) {
        getAllDetailMovie();
    }

    @Override
    public void reload(String movieId) {
        this.mMovieId = movieId;
        getAllDetailMovie();
    }

    @Override
    public void getAllDetailMovie() {
        mModel().getAllDetailMovie(mMovieId,
                getAllDetailMovieCallback(),
                getDetailsCallback(),
                getVideoCallback(),
                getSimilarCallback(),
                getRecommendationsCallback());
    }

    @Override
    public String getGenresText(List<GenreModel> listGenres) {
        StringBuilder genres = new StringBuilder("Genres: ");
        for (GenreModel item : listGenres) {
            genres.append(item.getName()).append(", ");
        }
        return genres.toString().trim().substring(0, genres.length() - 2);
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
                ActivityUtil.dismissProgressDialog(getActivity());
            }
        };
    }

    private CommonCallback<GetDetailsResponse> getDetailsCallback() {
        return new CommonCallback<GetDetailsResponse>(getActivity()) {
            @Override
            public void onCommonSuccess(GetDetailsResponse response) {
                super.onCommonSuccess(response);
                mView().onGetDetailSuccess(response);
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
                if (!CommonUtil.isNullOrEmpty(response.getResults())) {
                    mView().onGetSuggestSuccess(response.getResults());
                }
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
                if (!CommonUtil.isNullOrEmpty(response.getResults())) {
                    mView().onGetSuggestSuccess(response.getResults());
                }
            }

            @Override
            public void onCommonError(GetListMoviesResponse response) {
                super.onCommonError(response);
            }
        };
    }
}