package com.tungtt.reviewfilm.screens.nowplaying;

import com.tungtt.basemvp.mvp.model.BaseModelLayer;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 11:45
 */
public class NowPlayingModel extends BaseModelLayer<INowPlayingContract.Presenter>
        implements INowPlayingContract.Model {

    public static NowPlayingModel newInstance() {
        return new NowPlayingModel();
    }

    @Override
    public void init() {

    }
}
