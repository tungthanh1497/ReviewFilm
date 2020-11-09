package com.tungtt.reviewfilm.network.models.response.getdetails.response;

import com.google.gson.annotations.SerializedName;
import com.tungtt.reviewfilm.network.models.response.getdetails.CompanyModel;
import com.tungtt.reviewfilm.network.models.response.getdetails.CountryModel;
import com.tungtt.reviewfilm.network.models.response.getdetails.GenreModel;
import com.tungtt.reviewfilm.network.models.response.getdetails.LanguageModel;

import java.util.List;

public class GetDetailsResponse {

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("imdb_id")
    private String imdbId;

    @SerializedName("video")
    private boolean video;

    @SerializedName("title")
    private String title;

    @SerializedName("backdrop_path")
    private String backdropPath;

    @SerializedName("revenue")
    private String revenue;

    @SerializedName("genres")
    private List<GenreModel> genres;

    @SerializedName("popularity")
    private String popularity;

    @SerializedName("production_countries")
    private List<CountryModel> productionCountries;

    @SerializedName("id")
    private String id;

    @SerializedName("vote_count")
    private String voteCount;

    @SerializedName("budget")
    private String budget;

    @SerializedName("overview")
    private String overview;

    @SerializedName("original_title")
    private String originalTitle;

    @SerializedName("runtime")
    private String runtime;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("spoken_languages")
    private List<LanguageModel> spokenLanguages;

    @SerializedName("production_companies")
    private List<CompanyModel> productionCompanies;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("vote_average")
    private String voteAverage;

    @SerializedName("belongs_to_collection")
    private Object belongsToCollection;

    @SerializedName("tagline")
    private String tagline;

    @SerializedName("adult")
    private boolean adult;

    @SerializedName("homepage")
    private String homepage;

    @SerializedName("status")
    private String status;

    public String getOriginalLanguage() {
        return originalLanguage == null ? "" : originalLanguage;
    }

    public String getImdbId() {
        return imdbId == null ? "" : imdbId;
    }

    public boolean isVideo() {
        return video;
    }

    public String getTitle() {
        return title == null ? "" : title;
    }

    public String getBackdropPath() {
        return backdropPath == null ? "" : backdropPath;
    }

    public String getRevenue() {
        return revenue == null ? "" : revenue;
    }

    public List<GenreModel> getGenres() {
        return genres;
    }

    public String getPopularity() {
        return popularity == null ? "" : popularity;
    }

    public List<CountryModel> getProductionCountries() {
        return productionCountries;
    }

    public String getId() {
        return id == null ? "" : id;
    }

    public String getVoteCount() {
        return voteCount == null ? "" : voteCount;
    }

    public String getBudget() {
        return budget == null ? "" : budget;
    }

    public String getOverview() {
        return overview == null ? "" : overview;
    }

    public String getOriginalTitle() {
        return originalTitle == null ? "" : originalTitle;
    }

    public String getRuntime() {
        return runtime == null ? "" : runtime;
    }

    public String getPosterPath() {
        return posterPath == null ? "" : posterPath;
    }

    public List<LanguageModel> getSpokenLanguages() {
        return spokenLanguages;
    }

    public List<CompanyModel> getProductionCompanies() {
        return productionCompanies;
    }

    public String getReleaseDate() {
        return releaseDate == null ? "" : releaseDate;
    }

    public String getVoteAverage() {
        return voteAverage == null ? "" : voteAverage;
    }

    public Object getBelongsToCollection() {
        return belongsToCollection;
    }

    public String getTagline() {
        return tagline == null ? "" : tagline;
    }

    public boolean isAdult() {
        return adult;
    }

    public String getHomepage() {
        return homepage == null ? "" : homepage;
    }

    public String getStatus() {
        return status == null ? "" : status;
    }
}