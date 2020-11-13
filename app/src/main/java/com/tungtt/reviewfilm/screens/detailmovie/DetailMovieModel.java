package com.tungtt.reviewfilm.screens.detailmovie;

import com.tungtt.basemvp.mvp.model.BaseModelLayer;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 11:45
 */
public class DetailMovieModel extends BaseModelLayer<IDetailMovieContract.Presenter>
        implements IDetailMovieContract.Model {

    public static DetailMovieModel newInstance() {
        return new DetailMovieModel();
    }

    @Override
    public void init() {

    }
}
