package com.tungtt.reviewfilm.screens.home.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tungtt.reviewfilm.R;
import com.tungtt.reviewfilm.network.models.getlistmovies.MovieModel;
import com.tungtt.reviewfilm.utils.CommonUtil;
import com.tungtt.reviewfilm.utils.ImageUtil;
import com.tungtt.reviewfilm.widgets.RatioImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by tungtt a.k.a TungTT
 * On Wed, 11 Nov 2020 - 11:01
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private Context mContext;
    private List<MovieModel> mListMovie;
    private OnMovieListener mListener;
    private int mFixedDimensional;

    public MovieAdapter(Context context,
                        List<MovieModel> listGroupMovie,
                        @RatioImageView.TYPE_FIXED_DIMENSIONAL int fixedDimensional,
                        OnMovieListener listener) {
        this.mContext = context;
        this.mListMovie = listGroupMovie;
        this.mListener = listener;
        this.mFixedDimensional = fixedDimensional;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MovieModel model = mListMovie.get(position);
        holder.movieNameTextView.setText(model.getTitle());
        ImageUtil.loadImage(ImageUtil.SIZE_IMAGE.W300_H450, model.getPosterPath(), holder.moviePosterImageView);
        holder.moviePosterImageView.setFixedDimensional(mFixedDimensional);
        holder.moviePosterImageView.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onMovieClicked(model);
            }
        });
        holder.voteAverageTextView.setText(model.getVoteAverage());
        holder.voteAverageTextView.setVisibility(CommonUtil.isNullOrEmpty(model.getVoteAverage()) ? View.GONE : View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return mListMovie.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_movie_poster)
        RatioImageView moviePosterImageView;
        @BindView(R.id.tv_vote_average)
        TextView voteAverageTextView;
        @BindView(R.id.tv_movie_name)
        TextView movieNameTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnMovieListener {
        void onMovieClicked(MovieModel movieModel);
    }
}
