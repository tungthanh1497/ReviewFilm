package com.tungtt.reviewfilm.screens.search;

import android.util.Log;
import android.view.View;

import com.tungtt.basemvp.mvp.view.BaseViewLayer;
import com.tungtt.reviewfilm.R;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 11:47
 */
public class SearchView extends BaseViewLayer<ISearchContract.Presenter>
        implements ISearchContract.View {

    private androidx.appcompat.widget.SearchView searchView;

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
    }

    @Override
    public void init() {
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
