package com.tungtt.reviewfilm.models.response.getlistmovies;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetListMoviesResponse {

    @SerializedName("page")
    private String page;

    @SerializedName("total_pages")
    private String totalPages;

    @SerializedName("results")
    private List<MovieModel> results;

    @SerializedName("total_results")
    private String totalResults;

    public String getPage() {
        return page == null ? "" : page;
    }

    public String getTotalPages() {
        return totalPages == null ? "" : totalPages;
    }

    public List<MovieModel> getResults() {
        return results;
    }

    public String getTotalResults() {
        return totalResults == null ? "" : totalResults;
    }
}