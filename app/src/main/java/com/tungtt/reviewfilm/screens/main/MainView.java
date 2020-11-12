package com.tungtt.reviewfilm.screens.main;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.tungtt.basemvp.mvp.view.BaseViewLayer;
import com.tungtt.reviewfilm.R;
import com.tungtt.reviewfilm.screens.home.HomeFragment;
import com.tungtt.reviewfilm.screens.main.adapters.TabMenuAdapter;
import com.tungtt.reviewfilm.screens.search.SearchFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tungtt a.k.a TungTT
 * On Thu, 05 Nov 2020 - 11:55
 */
public class MainView extends BaseViewLayer<IMainContract.Presenter>
        implements IMainContract.View {

    private static final String TAG = MainView.class.getSimpleName();

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private TabMenuAdapter adapter;
    private List<Pair<String, Fragment>> mListFragments;

    public static MainView newInstance() {
        return new MainView();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.main_fragment;
    }

    @Override
    public void bindViews(View view) {
        tabLayout = view.findViewById(R.id.tl_tab_layout);
        viewPager = view.findViewById(R.id.vp_view_pager);
    }

    @Override
    public void init() {
        initViewPager();
        updateTab(0);
        implementListeners();
    }

    private void initViewPager() {
        mListFragments = new ArrayList<>();
        mListFragments.add(new Pair<String, Fragment>(
                "Home",
                HomeFragment.newInstance()));
        mListFragments.add(new Pair<String, Fragment>(
                "Search",
                SearchFragment.newInstance()));
        adapter = mPresenter().initTabMenuAdapter(mListFragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void implementListeners() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                updateTab(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void updateTab(int selectedPosition) {
        viewPager.setCurrentItem(selectedPosition);
        setUpCustomTabLayout(selectedPosition);
    }

    /**
     * update view of tab layout when change tab
     *
     * @param selectedPosition: selected tab position
     */
    private void setUpCustomTabLayout(int selectedPosition) {
        for (int tabPosition = 0; tabPosition < mListFragments.size(); tabPosition++) {
            if (tabLayout.getTabAt(tabPosition) != null) {
                if (tabLayout.getTabAt(tabPosition).getCustomView() != null) {
                    LinearLayout customTabLayout = (LinearLayout) tabLayout.getTabAt(tabPosition).getCustomView();
                    updateCustomTabLayout(customTabLayout, tabPosition, tabPosition == selectedPosition);
                } else {
                    LinearLayout customTabLayout = (LinearLayout) LayoutInflater.from(mActivity()).inflate(R.layout.item_tab_menu, null);
                    updateCustomTabLayout(customTabLayout, tabPosition, tabPosition == selectedPosition);
                    tabLayout.getTabAt(tabPosition).setCustomView(customTabLayout);
                }
            }
        }
    }

    /**
     * update tab selected
     *
     * @param customTabLayout:      tabLayout
     * @param tabPosition:          tab need to be updated layout
     * @param isCurrentTabSelected: current tab is selected
     */
    private void updateCustomTabLayout(LinearLayout customTabLayout, int tabPosition, boolean isCurrentTabSelected) {
        TextView titleTabTextView = customTabLayout.findViewById(R.id.tv_name);
        AppCompatImageView iconImageView = customTabLayout.findViewById(R.id.iv_icon);
        titleTabTextView.setText(mPresenter().getName(tabPosition));

        titleTabTextView.setTextAppearance(mPresenter().getTextAppearance(isCurrentTabSelected));
        titleTabTextView.setTextColor(mPresenter().getNameColor(isCurrentTabSelected));
        iconImageView.setImageResource(mPresenter().getIcon(tabPosition, isCurrentTabSelected));
    }
}
