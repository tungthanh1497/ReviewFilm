package com.tungtt.reviewfilm.network.models.getlistmovies.response;

import com.google.gson.annotations.SerializedName;
import com.tungtt.reviewfilm.network.models.SimpleResponse;
import com.tungtt.reviewfilm.network.models.getlistmovies.MovieModel;

import java.util.List;

public class GetListMoviesResponse extends SimpleResponse {

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

    @Override
    public String toString() {
        return "GetListMoviesResponse{" +
                "page='" + page + '\'' +
                ", totalPages='" + totalPages + '\'' +
                ", results=" + results +
                ", totalResults='" + totalResults + '\'' +
                '}';
    }
}