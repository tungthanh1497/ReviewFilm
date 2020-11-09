package com.tungtt.reviewfilm.models.response.getvideos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetVideosResponse {

    @SerializedName("id")
    private String id;

    @SerializedName("results")
    private List<VideoModel> results;

    public String getId() {
        return id == null ? "" : id;
    }

    public List<VideoModel> getResults() {
        return results;
    }
}