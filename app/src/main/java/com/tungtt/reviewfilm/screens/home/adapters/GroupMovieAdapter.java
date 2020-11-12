package com.tungtt.reviewfilm.screens.home.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tungtt.reviewfilm.R;
import com.tungtt.reviewfilm.screens.home.models.GroupMovieModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by tungtt a.k.a TungTT
 * On Wed, 11 Nov 2020 - 11:01
 */
public class GroupMovieAdapter extends RecyclerView.Adapter<GroupMovieAdapter.ViewHolder> {

    private Context mContext;
    private List<GroupMovieModel> mListGroupMovie;
    private OnGroupMovieListener mListener;

    public GroupMovieAdapter(Context context,
                             List<GroupMovieModel> listGroupMovie,
                             OnGroupMovieListener listener) {
        this.mContext = context;
        this.mListGroupMovie = listGroupMovie;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_group_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GroupMovieModel model = mListGroupMovie.get(position);
        holder.groupNameTextView.setText(model.getName());

        if (model.getListMovie() != null) {
            MovieAdapter adapter = new MovieAdapter(mContext, model.getListMovie(), new MovieAdapter.OnMovieListener() {
            });
            holder.movieRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            holder.movieRecyclerView.setItemAnimator(new DefaultItemAnimator());
            holder.movieRecyclerView.setAdapter(adapter);
        }
    }

    @Override
    public int getItemCount() {
        return mListGroupMovie.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_group_name)
        TextView groupNameTextView;
        @BindView(R.id.rv_movie)
        RecyclerView movieRecyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnGroupMovieListener {

    }
}
