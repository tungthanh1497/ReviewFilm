package com.tungtt.reviewfilm.network.models.searchkeywords.response;

import com.google.gson.annotations.SerializedName;
import com.tungtt.reviewfilm.network.models.SimpleResponse;
import com.tungtt.reviewfilm.network.models.searchkeywords.KeywordModel;

import java.util.List;

public class SearchKeyWordsResponse extends SimpleResponse {

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