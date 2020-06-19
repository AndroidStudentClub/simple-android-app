package ru.mikhailskiy.simplemovieapp.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface MovieDao {
    @Query("SELECT * FROM movie_table")
    List<MovieDb> getAll();


    @Insert
    void insertAll(List<MovieDb> movies);

}