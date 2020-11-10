package com.tungtt.reviewfilm.commons;

import androidx.appcompat.app.AppCompatActivity;

import com.tungtt.reviewfilm.utils.ActivityUtil;
import com.tungtt.reviewfilm.widgets.LoadingDialog;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 16:01
 */
public class BaseActivity extends AppCompatActivity {

    private LoadingDialog mLoadingDialog;

    public LoadingDialog getLoadingDialog() {
        return mLoadingDialog;
    }

    public void setLoadingDialog(LoadingDialog loadingDialog) {
        this.mLoadingDialog = loadingDialog;
    }

    public void showProgressDialog() {
        ActivityUtil.showProgressDialog(this);
    }


    public void dismissProgressDialog() {
        ActivityUtil.dismissProgressDialog(this);
    }
}
