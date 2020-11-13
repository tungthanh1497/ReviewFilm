package com.tungtt.reviewfilm.utils;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.StringRes;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 09:42
 */
public class ToastUtil {
    public static void showToast(Context context, String message) {
        if (!CommonUtil.isNullOrEmpty(message)) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }


    public static void showToast(Context context, @StringRes int stringId) {
        showToast(context, context.getResources().getString(stringId));
    }


}
