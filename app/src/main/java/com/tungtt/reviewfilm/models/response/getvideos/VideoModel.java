package com.tungtt.reviewfilm.models.response.getvideos;

import com.google.gson.annotations.SerializedName;

public class VideoModel {

    @SerializedName("site")
    private String site;

    @SerializedName("size")
    private String size;

    @SerializedName("iso_3166_1")
    private String iso31661;

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private String id;

    @SerializedName("type")
    private String type;

    @SerializedName("iso_639_1")
    private String iso6391;

    @SerializedName("key")
    private String key;

    public String getSite() {
        return site == null ? "" : site;
    }

    public String getSize() {
        return size == null ? "" : size;
    }

    public String getIso31661() {
        return iso31661 == null ? "" : iso31661;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public String getId() {
        return id == null ? "" : id;
    }

    public String getType() {
        return type == null ? "" : type;
    }

    public String getIso6391() {
        return iso6391 == null ? "" : iso6391;
    }

    public String getKey() {
        return key == null ? "" : key;
    }
}