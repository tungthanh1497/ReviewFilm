package com.tungtt.reviewfilm.utils;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.tungtt.reviewfilm.MainActivity;
import com.tungtt.reviewfilm.R;

/**
 * Created by tungtt a.k.a TungTT
 * On Thu, 05 Nov 2020 - 11:59
 */
public class ActivityUtil {

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
}
