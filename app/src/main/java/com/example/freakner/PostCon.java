package com.example.freakner;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PostCon {
    @Query("SELECT * FROM post WHERE id = :id")
    Post get(int id);

    @Query("SELECT * FROM post")
    List<Post> index();

    @Insert
    void insert(Post... contacts);

    @Delete
    void delete(Post... contacts);

    @Update
    void update(Post... contacts);

    @Query("SELECT * FROM Post WHERE userId = :username")
    List<Post> getContacts(String username);

    @Query("SELECT id FROM Post WHERE name = :contact AND userId= :username")
    int getChatId(String username, String contact);

}
