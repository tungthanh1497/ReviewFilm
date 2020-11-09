package com.tungtt.reviewfilm.models.response.searchkeywords;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchKeyWordsResponse {

    @SerializedName("page")
    private String page;

    @SerializedName("total_pages")
    private String totalPages;

    @SerializedName("results")
    private List<KeywordModel> results;

    @SerializedName("total_results")
    private String totalResults;

    public String getPage() {
        return page == null ? "" : page;
    }

    public String getTotalPages() {
        return totalPages == null ? "" : totalPages;
    }

    public List<KeywordModel> getResults() {
        return results;
    }

    public String getTotalResults() {
        return totalResults == null ? "" : totalResults;
    }
}