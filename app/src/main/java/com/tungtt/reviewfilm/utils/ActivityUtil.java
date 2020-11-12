package com.tungtt.reviewfilm.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;

import androidx.fragment.app.Fragment;

import com.tungtt.reviewfilm.MainActivity;
import com.tungtt.reviewfilm.R;
import com.tungtt.reviewfilm.commons.BaseActivity;
import com.tungtt.reviewfilm.widgets.LoadingDialog;

/**
 * Created by tungtt a.k.a TungTT
 * On Thu, 05 Nov 2020 - 11:59
 */
public class ActivityUtil {

    private static final String TAG = ActivityUtil.class.getSimpleName();

    public static void addScreen(Fragment fragment, String tag) {
        addScreen(fragment, tag, null);
    }

    /**
     * open a new Fragment and add to backstack
     *
     * @param fragment: destination fragment
     * @param tag:      fragment's TAG
     * @param data:     bundle to transfer data (if needed)
     */
    public static void addScreen(Fragment fragment,
                                 String tag,
                                 Bundle data) {
        if (data != null) {
            fragment.setArguments(data);
        }
        MainActivity.getInstance().getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, fragment)
                .addToBackStack(tag)
                .commit();
    }

    public static void hideKeyboard(Activity activity) {
        try {
            InputMethodManager imm = (InputMethodManager) activity
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                if (activity.getCurrentFocus() != null) {
                    imm.hideSoftInputFromWindow(
                            activity.getCurrentFocus().getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS
                    );
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "hideKeyboard: ", e);
        }
    }


    public static void showProgressDialog(Activity activity) {
        if (activity instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) activity;
            ActivityUtil.hideKeyboard(baseActivity);
            if (baseActivity.getLoadingDialog() != null) {
                try {
                    baseActivity.getLoadingDialog().cancel();
                } catch (Exception ex) {
                    Log.e(TAG, "showProgressDialog: ", ex);
                }
            }

            LoadingDialog loadingDialog = new LoadingDialog(baseActivity);
            loadingDialog.setTitle("");
            loadingDialog.setCancelable(true);
            loadingDialog.setOnCancelListener(null);
            loadingDialog.setCanceledOnTouchOutside(false);
            baseActivity.setLoadingDialog(loadingDialog);
            baseActivity.getLoadingDialog().show();
        }
    }


    public static void dismissProgressDialog(Activity activity) {
        if (activity instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) activity;
            if (baseActivity.getLoadingDialog() != null) {
                try {
                    baseActivity.getLoadingDialog().dismiss();
                } catch (Exception ex) {
                    Log.e(TAG, "dismissProgressDialog: ", ex);
                }
            }
        }
    }
}
