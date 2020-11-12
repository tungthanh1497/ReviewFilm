package com.tungtt.reviewfilm.screens.main;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.Pair;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.tungtt.basemvp.BaseFragment;
import com.tungtt.reviewfilm.R;
import com.tungtt.reviewfilm.network.CommonCallback;
import com.tungtt.reviewfilm.network.models.getlistmovies.response.GetListMoviesResponse;
import com.tungtt.reviewfilm.screens.main.adapters.TabMenuAdapter;
import com.tungtt.reviewfilm.utils.ActivityUtil;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

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
        callGetAllTabData();
    }

    @Override
    public void callGetAllTabData() {
        mModel().getAllTabData(getAllTaDataCallback(),
                getUpcomingCallback(),
                getUpcomingCallback(),
                getUpcomingCallback(),
                getUpcomingCallback()
        );
    }

    @Override
    public TabMenuAdapter initTabMenuAdapter(List<Pair<String, Fragment>> listFragments) {
        return new TabMenuAdapter(getChildFragmentManager(), listFragments);
    }

    private CommonCallback<GetListMoviesResponse> getUpcomingCallback() {
        return new CommonCallback<GetListMoviesResponse>(getActivity()) {
            @Override
            public void onCommonSuccess(GetListMoviesResponse response) {
                super.onCommonSuccess(response);
                Log.d(TAG, "onCommonSuccess: " + response);
            }

            @Override
            public void onCommonError(GetListMoviesResponse response) {
                super.onCommonError(response);
                Log.e(TAG, "onCommonError: " + response);
            }
        };
    }

    private Observer<Object> getAllTaDataCallback() {
        return new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {
                ActivityUtil.showProgressDialog(getActivity());
                Log.d(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(Object o) {
                Log.d(TAG, "onNext: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ");
            }

            @Override
            public void onComplete() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        ActivityUtil.dismissProgressDialog(getActivity());
                        Log.d(TAG, "onComplete: ");
                    }
                }, 5000);
            }
        };
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
