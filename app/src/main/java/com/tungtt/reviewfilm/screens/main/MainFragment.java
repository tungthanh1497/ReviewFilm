package com.tungtt.reviewfilm.screens.main;

import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.tungtt.basemvp.BaseFragment;
import com.tungtt.reviewfilm.R;
import com.tungtt.reviewfilm.screens.main.adapters.TabMenuAdapter;

import java.util.List;

/**
 * Created by tungtt a.k.a TungTT
 * On Thu, 05 Nov 2020 - 11:54
 */
public class MainFragment extends BaseFragment<IMainContract.View, IMainContract.Model>
        implements IMainContract.Presenter {

    private static final String TAG = MainFragment.class.toString();

    private int[] navIcons = {
            R.drawable.ic_home,
            R.drawable.ic_search
    };
    private int[] navIconsActive = {
            R.drawable.ic_home_selected,
            R.drawable.ic_search_selected
    };
    private int[] navLabels = {
            R.string.name_tab_home,
            R.string.name_tab_search
    };

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void initViewModel() {
        initModelLayer(MainModel.newInstance());
        initViewLayer(MainView.newInstance());
    }

    @Override
    public void onReceiveData(@NonNull Bundle data) {

    }

    @Override
    public void init(View view) {
    }

    @Override
    public TabMenuAdapter initTabMenuAdapter(List<Pair<String, Fragment>> listFragments) {
        return new TabMenuAdapter(getChildFragmentManager(), listFragments);
    }

    @Override
    public String getName(int position) {
        return getResources().getString(navLabels[position]);
    }

    @Override
    public int getNameColor(boolean isTabSelected) {
        return getResources().getColor(isTabSelected ? R.color.colorAccent : R.color.colorDisable);
    }

    @Override
    public int getIcon(int position, boolean isTabSelected) {
        return isTabSelected ? navIconsActive[position] : navIcons[position];
    }

    @Override
    public int getTextAppearance(boolean isTabSelected) {
        return isTabSelected ? R.style.textViewBold : R.style.textViewMedium;
    }
}
