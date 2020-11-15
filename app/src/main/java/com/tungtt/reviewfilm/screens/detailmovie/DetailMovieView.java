package com.tungtt.reviewfilm.screens.detailmovie;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.tungtt.basemvp.mvp.view.BaseViewLayer;
import com.tungtt.reviewfilm.R;
import com.tungtt.reviewfilm.network.models.getdetails.response.GetDetailsResponse;
import com.tungtt.reviewfilm.network.models.getlistmovies.MovieModel;
import com.tungtt.reviewfilm.screens.home.adapters.MovieAdapter;
import com.tungtt.reviewfilm.utils.CommonUtil;
import com.tungtt.reviewfilm.utils.ImageUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 11:47
 */
public class DetailMovieView extends BaseViewLayer<IDetailMovieContract.Presenter>
        implements IDetailMovieContract.View {

    private YouTubePlayerView youtubePlayerView;
    private ImageView backdropImageView;
    private ImageView posterImageView;
    private TextView titleTextView;
    private TextView releaseDateTextView;
    private TextView overviewTextView;
    private RecyclerView suggestRecyclerView;
    private SwipeRefreshLayout pullToRefreshLayout;

    private YouTubePlayer mYoutubePlayer;
    private String mVideoKey;
    private List<MovieModel> mListMovie;
    private MovieAdapter mAdapter;

    public static DetailMovieView newInstance() {
        return new DetailMovieView();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_detail_movie;
    }

    @Override
    public void bindViews(View view) {
        youtubePlayerView = view.findViewById(R.id.ytpv_youtube_player);
        backdropImageView = view.findViewById(R.id.iv_movie_backdrop);
        posterImageView = view.findViewById(R.id.iv_movie_poster);
        titleTextView = view.findViewById(R.id.tv_movie_title);
        releaseDateTextView = view.findViewById(R.id.tv_release_date);
        overviewTextView = view.findViewById(R.id.tv_overview);
        suggestRecyclerView = view.findViewById(R.id.rv_suggest);
        pullToRefreshLayout = view.findViewById(R.id.srl_pull_to_refresh);
    }

    @Override
    public void init() {
        implementListeners();
        initYoutubePlayer();
        initRecyclerView();
    }

    @Override
    public void onGetVideoSuccess(String videoKey) {
        mVideoKey = videoKey;
        if (!CommonUtil.isNullOrEmpty(mYoutubePlayer)) {
            mYoutubePlayer.cueVideo(mVideoKey, 0);
        }
    }

    @Override
    public void onGetDetailSuccess(GetDetailsResponse detailMovie) {
        ImageUtil.loadImage(ImageUtil.SIZE_IMAGE.W600_H900, detailMovie.getBackdropPath(), backdropImageView);
        ImageUtil.loadImage(ImageUtil.SIZE_IMAGE.W300_H450, detailMovie.getPosterPath(), posterImageView);
        titleTextView.setText(detailMovie.getOriginalTitle());
        releaseDateTextView.setText(detailMovie.getReleaseDate());
        overviewTextView.setText(detailMovie.getOverview());

    }

    @Override
    public void onGetSuggestSuccess(List<MovieModel> results) {
        mListMovie.addAll(results);
        mAdapter.notifyDataSetChanged();
    }

    private void initYoutubePlayer() {
        youtubePlayerView.getYouTubePlayerWhenReady(youTubePlayer -> {
            mYoutubePlayer = youTubePlayer;
            if (!CommonUtil.isNullOrEmpty(mVideoKey)) {
                youTubePlayer.cueVideo(mVideoKey, 0);
            }
        });
    }

    private void initRecyclerView() {
        mListMovie = new ArrayList<>();
        mAdapter = new MovieAdapter(mActivity(), mListMovie, movieModel -> {
            mListMovie.clear();
            mPresenter().reload(movieModel.getId());
        });
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mActivity(), 2);
        gridLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        suggestRecyclerView.setLayoutManager(gridLayoutManager);
        suggestRecyclerView.setItemAnimator(new DefaultItemAnimator());
        suggestRecyclerView.setAdapter(mAdapter);
    }

    private void implementListeners() {
        pullToRefreshLayout.setOnRefreshListener(() -> {
            pullToRefreshLayout.setRefreshing(false);
            mListMovie.clear();
            mPresenter().getAllDetailMovie();
        });
    }
}
