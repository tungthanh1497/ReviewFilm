package com.tungtt.reviewfilm.screens.tabcontent;

import com.tungtt.basemvp.mvp.model.BaseModelLayer;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 11:45
 */
public class TabContentModel extends BaseModelLayer<ITabContentContract.Presenter>
        implements ITabContentContract.Model {

    public static TabContentModel newInstance() {
        return new TabContentModel();
    }

    @Override
    public void init() {

    }
}
