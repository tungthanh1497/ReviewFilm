package com.tungtt.reviewfilm.network.models.getdetails.request;

/**
 * Created by tungtt a.k.a TungTT
 * On Mon, 09 Nov 2020 - 16:12
 */
public class GetDetailsRequest {
    private String mId;

    public GetDetailsRequest(String id) {
        this.mId = id;
    }

    public String getId() {
        return mId == null ? "" : mId;
    }
}
