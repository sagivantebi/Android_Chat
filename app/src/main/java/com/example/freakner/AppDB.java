package com.example.freakner;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Post.class}, version = 1)
public abstract class AppDB extends RoomDatabase {
    public abstract PostCon postCon();
}
