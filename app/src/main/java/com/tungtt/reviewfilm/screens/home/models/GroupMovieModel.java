package com.tungtt.reviewfilm.screens.home.models;

import com.tungtt.reviewfilm.network.models.getlistmovies.MovieModel;

import java.util.List;

/**
 * Created by tungtt a.k.a TungTT
 * On Wed, 11 Nov 2020 - 11:07
 */
public class GroupMovieModel {
    private String name;
    private List<MovieModel> listMovie;

    public GroupMovieModel(String name, List<MovieModel> listMovie) {
        this.name = name;
        this.listMovie = listMovie;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public List<MovieModel> getListMovie() {
        return listMovie;
    }
}
