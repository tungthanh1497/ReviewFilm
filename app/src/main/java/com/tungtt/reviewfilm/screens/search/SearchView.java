package com.tungtt.reviewfilm.screens.search;

import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tungtt.basemvp.mvp.view.BaseViewLayer;
import com.tungtt.reviewfilm.R;
import com.tungtt.reviewfilm.network.models.getlistmovies.MovieModel;
import com.tungtt.reviewfilm.screens.home.adapters.MovieAdapter;
import com.tungtt.reviewfilm.widgets.RatioImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 11:47
 */
public class SearchView extends BaseViewLayer<ISearchContract.Presenter>
        implements ISearchContract.View {

    private androidx.appcompat.widget.SearchView searchView;
    private RecyclerView resultRecyclerView;

    private List<MovieModel> mListMovie;
    private MovieAdapter mAdapter;

    public static SearchView newInstance() {
        return new SearchView();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_search;
    }

    @Override
    public void bindViews(View view) {
        searchView = view.findViewById(R.id.sv_search);
        resultRecyclerView = view.findViewById(R.id.rv_result);
    }

    @Override
    public void init() {
        implementListeners();
        initRecyclerView();
    }

    @Override
    public void onSearchSuccess(List<MovieModel> results) {
        mListMovie.clear();
        mListMovie.addAll(results);
        mAdapter.notifyDataSetChanged();
    }

    private void initRecyclerView() {
        mListMovie = new ArrayList<>();
        mAdapter = new MovieAdapter(mActivity(), mListMovie, RatioImageView.TYPE_FIXED_DIMENSIONAL.WIDTH, movieModel -> {
            mPresenter().moveToDetailMovie(movieModel);
        });
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mActivity(), 3);
        resultRecyclerView.setLayoutManager(gridLayoutManager);
        resultRecyclerView.setItemAnimator(new DefaultItemAnimator());
        resultRecyclerView.setAdapter(mAdapter);
    }

    private void implementListeners() {
        searchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mPresenter().searchMovies(query);
                searchView.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("TAG", "onQueryTextChange: " + newText);
                return true;
            }
        });
    }
}
