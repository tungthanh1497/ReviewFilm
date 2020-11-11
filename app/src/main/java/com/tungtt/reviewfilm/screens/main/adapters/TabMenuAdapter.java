package com.tungtt.reviewfilm.screens.main.adapters;

import android.util.Pair;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 17:16
 */
public class TabMenuAdapter extends FragmentPagerAdapter {

    private List<Pair<String, Fragment>> mListFragments;

    public TabMenuAdapter(@NonNull FragmentManager fm, List<Pair<String, Fragment>> listFragments) {
        super(fm);
        setFragments(listFragments);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mListFragments.get(position).first;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mListFragments.get(position).second;
    }

    @Override
    public int getCount() {
        return mListFragments.size();
    }

    @Override
    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.setPrimaryItem(container, position, object);
    }

    private void setFragments(List<Pair<String, Fragment>> fragments) {
        if (mListFragments != null) {
            mListFragments.clear();
        } else {
            mListFragments = new ArrayList<>();
        }
        if (fragments != null) {
            mListFragments.addAll(fragments);
        }
        notifyDataSetChanged();
    }
}
