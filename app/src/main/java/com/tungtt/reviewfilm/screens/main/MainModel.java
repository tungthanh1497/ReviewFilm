package com.tungtt.reviewfilm.screens.main;

import com.tungtt.basemvp.mvp.model.BaseModelLayer;

import java.util.Random;

/**
 * Created by tungtt a.k.a TungTT
 * On Thu, 05 Nov 2020 - 11:58
 */
public class MainModel extends BaseModelLayer<IMainContract.Presenter>
        implements IMainContract.Model {

    public static MainModel newInstance() {
        return new MainModel();
    }

    @Override
    public boolean isEven() {
        int random = new Random().nextInt(10);
        return random % 2 == 0;
    }
}
