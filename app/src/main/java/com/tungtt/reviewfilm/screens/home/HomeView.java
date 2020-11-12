package com.tungtt.reviewfilm.screens.home;

import android.view.View;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.tungtt.basemvp.mvp.view.BaseViewLayer;
import com.tungtt.reviewfilm.R;
import com.tungtt.reviewfilm.network.models.getlistmovies.MovieModel;
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

    private SwipeRefreshLayout pullToRefreshLayout;
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
        pullToRefreshLayout = view.findViewById(R.id.srl_pull_to_refresh);
        groupMovieRecyclerView = view.findViewById(R.id.rv_group_movie);
    }

    @Override
    public void init() {
        implementListeners();
        initRecyclerView();
        getAllData();
    }

    @Override
    public void onGetGroupMovieSuccess(String groupMovieName, List<MovieModel> listMovie) {
        mListGroupMovie.add(new GroupMovieModel(groupMovieName, listMovie));
    }

    @Override
    public void onLoadAllDataSuccess() {
        mAdapter.notifyDataSetChanged();
    }

    private void initRecyclerView() {
        mListGroupMovie = new ArrayList<>();
        mAdapter = new GroupMovieAdapter(mActivity(), mListGroupMovie, new GroupMovieAdapter.OnGroupMovieListener() {
        });
        groupMovieRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity(), LinearLayoutManager.VERTICAL, false));
        groupMovieRecyclerView.setItemAnimator(new DefaultItemAnimator());
        groupMovieRecyclerView.setAdapter(mAdapter);
    }

    private void getAllData() {
        mListGroupMovie.clear();
        mPresenter().getAllData();
    }

    private void implementListeners() {
        pullToRefreshLayout.setOnRefreshListener(() -> {
            pullToRefreshLayout.setRefreshing(false);
            getAllData();
        });
    }
}
