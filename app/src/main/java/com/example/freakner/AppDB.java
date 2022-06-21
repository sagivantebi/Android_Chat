package com.example.freakner;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Post.class,Message.class,User.class}, version = 6)
public abstract class AppDB extends RoomDatabase {
    public abstract PostCon postCon();
    public abstract MesCon mesCon();
    public abstract UserCon userCon();
}