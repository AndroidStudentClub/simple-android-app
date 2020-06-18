package ru.mikhailskiy.simplemovieapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {
    Integer page;
    List<Movie> results;
    @SerializedName("total_results")
    Integer totalResults;
    @SerializedName("total_pages")
    Integer totalPages;
}
