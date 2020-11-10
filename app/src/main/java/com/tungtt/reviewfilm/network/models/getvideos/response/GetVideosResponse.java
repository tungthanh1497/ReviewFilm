package com.tungtt.reviewfilm.network.models.getvideos.response;

import com.google.gson.annotations.SerializedName;
import com.tungtt.reviewfilm.network.models.getvideos.VideoModel;

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