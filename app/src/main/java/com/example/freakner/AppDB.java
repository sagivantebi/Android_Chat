package com.example.freakner;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Post.class,Message.class}, version = 4)
public abstract class AppDB extends RoomDatabase {
    public abstract PostCon postCon();
    public abstract MesCon mesCon();
}