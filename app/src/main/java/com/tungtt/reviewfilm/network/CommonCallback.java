package com.tungtt.reviewfilm.network;

import android.content.Context;
import android.util.Log;

import com.tungtt.reviewfilm.network.models.SimpleResponse;
import com.tungtt.reviewfilm.utils.ToastUtil;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import retrofit2.Response;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 09:26
 */
public class CommonCallback<T extends SimpleResponse> {

    private static final String TAG = CommonCallback.class.getSimpleName();

    @Retention(RetentionPolicy.SOURCE)
    private @interface STATUS_CODE {
        int SUCCESS_MIN = 200;
        int SUCCESS_MAX = 299;
    }

    private Context mContext;

    public CommonCallback(Context context) {
        this.mContext = context;
    }

    /**
     * function need to be called in doOnNext() when call api
     * handle response and define this api is call success or failure
     * include check valid of token
     *
     * @param response: response received from server
     */
    public void onResponse(Response<T> response) {
        if (response != null
                && response.code() >= STATUS_CODE.SUCCESS_MIN
                && response.code() <= STATUS_CODE.SUCCESS_MAX
                && response.body() != null) {
            onCommonSuccess(response.body());
        } else if (response != null) {
            onCommonError(response.body());
        } else {
            onCommonError(null);
        }
    }

    /**
     * function need be called in doOnError() when call api
     *
     * @param throwable: throwable be thrown when catch error
     */
    public void onError(Throwable throwable) {
        if (throwable != null) {
            ToastUtil.showToast(mContext, throwable.getMessage());
            Log.e(TAG, "onError: ", throwable);
        }
        onCommonError(null);
    }

    /**
     * function need be override when call api
     *
     * @param response: data received from server
     */
    public void onCommonSuccess(T response) {
        Log.d(TAG, "onCommonSuccess: " + response);
    }

    /**
     * function need be override when call api
     *
     * @param response
     */
    public void onCommonError(T response) {
        if (response != null) {
            Log.e(TAG, "onCommonError: " + response);
        }
    }
}
