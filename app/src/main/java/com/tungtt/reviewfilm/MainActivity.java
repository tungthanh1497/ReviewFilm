package com.tungtt.reviewfilm;

import android.os.Bundle;

import com.tungtt.reviewfilm.commons.BaseActivity;
import com.tungtt.reviewfilm.screens.main.MainFragment;
import com.tungtt.reviewfilm.utils.ActivityUtil;
import com.tungtt.reviewfilm.utils.Constant;

public class MainActivity extends BaseActivity {

    private static MainActivity instance;

    public static MainActivity getInstance() {
        if (instance == null) {
            instance = new MainActivity();
        }
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance = this;
        ActivityUtil.addScreen(MainFragment.newInstance(), Constant.SCREEN_TAG.MAIN);
    }
}