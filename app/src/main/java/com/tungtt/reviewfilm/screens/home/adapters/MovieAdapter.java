package com.tungtt.reviewfilm.screens.home.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.tungtt.reviewfilm.R;
import com.tungtt.reviewfilm.network.models.getlistmovies.MovieModel;
import com.tungtt.reviewfilm.utils.ImageUtil;

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

    public MovieAdapter(Context context,
                        List<MovieModel> listGroupMovie,
                        OnMovieListener listener) {
        this.mContext = context;
        this.mListMovie = listGroupMovie;
        this.mListener = listener;
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
    }

    @Override
    public int getItemCount() {
        return mListMovie.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_movie_poster)
        AppCompatImageView moviePosterImageView;
        @BindView(R.id.tv_movie_name)
        TextView movieNameTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnMovieListener {

    }
}
