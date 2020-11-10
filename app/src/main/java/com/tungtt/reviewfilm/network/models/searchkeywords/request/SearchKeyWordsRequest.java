package com.tungtt.reviewfilm.network.models.searchkeywords.request;

/**
 * Created by tungtt a.k.a TungTT
 * On Mon, 09 Nov 2020 - 16:14
 */
public class SearchKeyWordsRequest {
    private String mQuery;

    public SearchKeyWordsRequest(String query) {
        this.mQuery = query;
    }

    public String getQuery() {
        return mQuery;
    }
}
