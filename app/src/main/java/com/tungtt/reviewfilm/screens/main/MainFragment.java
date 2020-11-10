package com.tungtt.reviewfilm.screens.main;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import com.tungtt.basemvp.BaseFragment;
import com.tungtt.reviewfilm.network.CommonCallback;
import com.tungtt.reviewfilm.network.models.getlistmovies.response.GetListMoviesResponse;
import com.tungtt.reviewfilm.utils.ActivityUtil;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by tungtt a.k.a TungTT
 * On Thu, 05 Nov 2020 - 11:54
 */
public class MainFragment extends BaseFragment<IMainContract.View, IMainContract.Model>
        implements IMainContract.Presenter {

    private static final String TAG = MainFragment.class.toString();

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
}
