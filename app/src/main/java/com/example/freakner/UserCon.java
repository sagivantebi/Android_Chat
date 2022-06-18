package com.example.freakner;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface UserCon {
    @Query("SELECT * FROM User WHERE username = :username")
    User get(String username);

    @Query("SELECT * FROM User")
    List<User> index();

    @Insert
    void insert(User... users);

    @Delete
    void delete(User... users);

    @Update
    void update(User... users);
//
//    @Query("SELECT * FROM USer WHERE userId = :userId")
//    List<Post> getContacts(String userId);
}
