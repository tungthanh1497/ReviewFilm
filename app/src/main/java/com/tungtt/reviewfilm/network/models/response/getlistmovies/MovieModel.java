package com.tungtt.reviewfilm.network.models.response.getlistmovies;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieModel {

    @SerializedName("overview")
    private String overview;

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("original_title")
    private String originalTitle;

    @SerializedName("video")
    private boolean video;

    @SerializedName("title")
    private String title;

    @SerializedName("genre_ids")
    private List<Integer> genreIds;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("backdrop_path")
    private String backdropPath;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("popularity")
    private String popularity;

    @SerializedName("vote_average")
    private String voteAverage;

    @SerializedName("id")
    private String id;

    @SerializedName("adult")
    private boolean adult;

    @SerializedName("vote_count")
    private String voteCount;

    public String getOverview() {
        return overview == null ? "" : overview;
    }

    public String getOriginalLanguage() {
        return originalLanguage == null ? "" : originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle == null ? "" : originalTitle;
    }

    public boolean isVideo() {
        return video;
    }

    public String getTitle() {
        return title == null ? "" : title;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public String getPosterPath() {
        return posterPath == null ? "" : posterPath;
    }

    public String getBackdropPath() {
        return backdropPath == null ? "" : backdropPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getPopularity() {
        return popularity == null ? "" : popularity;
    }

    public String getVoteAverage() {
        return voteAverage == null ? "" : voteAverage;
    }

    public String getId() {
        return id == null ? "" : id;
    }

    public boolean isAdult() {
        return adult;
    }

    public String getVoteCount() {
        return voteCount == null ? "" : voteCount;
    }
}