package com.tungtt.reviewfilm.network.models.response.getvideos.request;

/**
 * Created by tungtt a.k.a TungTT
 * On Mon, 09 Nov 2020 - 16:13
 */
public class GetVideosRequest {
    private String mId;

    public GetVideosRequest(String id) {
        this.mId = id;
    }

    public String getId() {
        return mId == null ? "" : mId;
    }
}
