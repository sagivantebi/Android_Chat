package com.example.freakner;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MesCon {
    @Query("SELECT * FROM message WHERE id = :id")
    Post get(int id);

    @Query("SELECT * FROM message")
    List<Message> index();

    @Insert
    void insert(Message... messages);

    @Delete
    void delete(Message... messages);

    @Update
    void update(Message... messages);

    @Query("SELECT * FROM message WHERE chatId = :id")
    List<Message> getMessages(int id);

}
