package ru.mikhailskiy.simplemovieapp.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {MovieDb.class}, version = 1)
public abstract class MovieDatabase extends RoomDatabase {
    public abstract MovieDao movieDao();
}