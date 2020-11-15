package com.tungtt.reviewfilm.screens.detailmovie;

import android.view.View;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.tungtt.basemvp.mvp.view.BaseViewLayer;
import com.tungtt.reviewfilm.R;
import com.tungtt.reviewfilm.utils.CommonUtil;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 11:47
 */
public class DetailMovieView extends BaseViewLayer<IDetailMovieContract.Presenter>
        implements IDetailMovieContract.View {

    private YouTubePlayerView youtubePlayerView;

    private boolean mIsYouTubePlayerReady = false;
    private String mVideoKey;

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
    }

    @Override
    public void init() {
        initYoutubePlayer();
    }

    private void initYoutubePlayer() {
        youtubePlayerView.getYouTubePlayerWhenReady(youTubePlayer -> {
            mIsYouTubePlayerReady = true;
            if (!CommonUtil.isNullOrEmpty(mVideoKey)) {
                youTubePlayer.cueVideo(mVideoKey, 0);
            }
        });
    }
}
