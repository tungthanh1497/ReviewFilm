package com.tungtt.reviewfilm.models.response.searchkeywords;

import com.google.gson.annotations.SerializedName;

public class KeywordModel {

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