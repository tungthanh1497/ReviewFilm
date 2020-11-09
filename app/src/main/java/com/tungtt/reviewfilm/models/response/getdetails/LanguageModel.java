package com.tungtt.reviewfilm.models.response.getdetails;

import com.google.gson.annotations.SerializedName;

public class LanguageModel {

    @SerializedName("name")
    private String name;

    @SerializedName("iso_639_1")
    private String iso6391;

    public String getName() {
        return name == null ? "" : name;
    }

    public String getIso6391() {
        return iso6391 == null ? "" : iso6391;
    }
}