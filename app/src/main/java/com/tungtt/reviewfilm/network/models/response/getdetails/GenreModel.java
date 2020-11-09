package com.tungtt.reviewfilm.network.models.response.getdetails;

import com.google.gson.annotations.SerializedName;

public class GenreModel {

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private String id;

    public String getName() {
        return name == null ? "" : name;
    }

    public String getId() {
        return id == null ? "" : id;
    }
}