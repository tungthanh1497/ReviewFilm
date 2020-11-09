package com.tungtt.reviewfilm.network.models.response.getdetails;

import com.google.gson.annotations.SerializedName;

public class CompanyModel {

    @SerializedName("logo_path")
    private String logoPath;

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private String id;

    @SerializedName("origin_country")
    private String originCountry;

    public String getLogoPath() {
        return logoPath == null ? "" : logoPath;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public String getId() {
        return id == null ? "" : id;
    }

    public String getOriginCountry() {
        return originCountry == null ? "" : originCountry;
    }
}