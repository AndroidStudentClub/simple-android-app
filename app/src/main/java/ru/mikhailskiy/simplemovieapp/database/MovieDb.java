package ru.mikhailskiy.simplemovieapp.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "movie_table")
public class MovieDb {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "movie_name")
    public String movieName;

    @ColumnInfo(name = "movie_desc")
    public String movieDesc;

    public MovieDb(int uid, String movieName, String movieDesc) {
        this.uid = uid;
        this.movieName = movieName;
        this.movieDesc = movieDesc;
    }
}