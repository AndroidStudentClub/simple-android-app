package ru.mikhailskiy.simplemovieapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {
    @SerializedName("adult")
    Boolean isAdult;
    @SerializedName("overview")
    String overview;
    @SerializedName("release_date")
    String releaseDate;
    List<Integer> genreIds;
    @SerializedName("id")
    Integer id;
    @SerializedName("original_title")
    String originalTitle;
    @SerializedName("original_language")
    String originalLanguage;
    @SerializedName("title")
    String title;
    @SerializedName("backdrop_path")
    String backdropPath;
    @SerializedName("popularity")
    Double popularity;
    @SerializedName("vote_count")
    Integer voteCount;
    @SerializedName("video")
    Boolean video;
    @SerializedName("vote_average")
    Double voteAverage;
    @SerializedName("poster_path")
    String posterPath;

    public String getPosterPath() {
        return "https://image.tmdb.org/t/p/w500$field" + posterPath;
    }
}
