package com.tungtt.reviewfilm.screens.detailmovie;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.tungtt.basemvp.mvp.view.BaseViewLayer;
import com.tungtt.reviewfilm.R;
import com.tungtt.reviewfilm.network.models.getdetails.response.GetDetailsResponse;
import com.tungtt.reviewfilm.utils.CommonUtil;
import com.tungtt.reviewfilm.utils.ImageUtil;

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

    private YouTubePlayer mYoutubePlayer;
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
        backdropImageView = view.findViewById(R.id.iv_movie_backdrop);
        posterImageView = view.findViewById(R.id.iv_movie_poster);
        titleTextView = view.findViewById(R.id.tv_movie_title);
        releaseDateTextView = view.findViewById(R.id.tv_release_date);
        overviewTextView = view.findViewById(R.id.tv_overview);
    }

    @Override
    public void init() {
        initYoutubePlayer();
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

    private void initYoutubePlayer() {
        youtubePlayerView.getYouTubePlayerWhenReady(youTubePlayer -> {
            mYoutubePlayer = youTubePlayer;
            if (!CommonUtil.isNullOrEmpty(mVideoKey)) {
                youTubePlayer.cueVideo(mVideoKey, 0);
            }
        });
    }
}
