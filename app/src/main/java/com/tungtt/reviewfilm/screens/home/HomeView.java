package com.tungtt.reviewfilm.screens.home;

import android.view.View;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tungtt.basemvp.mvp.view.BaseViewLayer;
import com.tungtt.reviewfilm.R;
import com.tungtt.reviewfilm.screens.home.adapters.GroupMovieAdapter;
import com.tungtt.reviewfilm.screens.home.models.GroupMovieModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 11:47
 */
public class HomeView extends BaseViewLayer<IHomeContract.Presenter>
        implements IHomeContract.View {

    private RecyclerView groupMovieRecyclerView;
    private List<GroupMovieModel> mListGroupMovie;
    private GroupMovieAdapter mAdapter;

    public static HomeView newInstance() {
        return new HomeView();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    public void bindViews(View view) {
        groupMovieRecyclerView = view.findViewById(R.id.rv_group_movie);
    }

    @Override
    public void init() {
        initRecyclerView();
        fakeDatas();
    }

    private void initRecyclerView() {
        mListGroupMovie = new ArrayList<>();
        mAdapter = new GroupMovieAdapter(mActivity(), mListGroupMovie, new GroupMovieAdapter.OnGroupMovieListener() {
        });
        groupMovieRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity(), LinearLayoutManager.VERTICAL, false));
        groupMovieRecyclerView.setItemAnimator(new DefaultItemAnimator());
        groupMovieRecyclerView.setAdapter(mAdapter);
    }

    private void fakeDatas() {
        mListGroupMovie.add(new GroupMovieModel("TungTT", null));
        mListGroupMovie.add(new GroupMovieModel("Upcoming", null));
        mListGroupMovie.add(new GroupMovieModel("New", null));
        mAdapter.notifyDataSetChanged();
    }
}
