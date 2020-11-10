package com.tungtt.reviewfilm.network.models.getlistmovies.request;

/**
 * Created by tungtt a.k.a TungTT
 * On Mon, 09 Nov 2020 - 16:13
 */
public class GetListMoviesRequest {
    private String mPage;

    public GetListMoviesRequest(int page) {
        this.mPage = String.valueOf(page);
    }

    public String getPage() {
        return mPage == null ? "" : mPage;
    }
}
