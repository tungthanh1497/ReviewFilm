package com.tungtt.reviewfilm.screens.search;

import com.tungtt.basemvp.mvp.model.BaseModelLayer;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 11:45
 */
public class SearchModel extends BaseModelLayer<ISearchContract.Presenter>
        implements ISearchContract.Model {

    public static SearchModel newInstance() {
        return new SearchModel();
    }

    @Override
    public void init() {

    }
}
