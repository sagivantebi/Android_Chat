package com.example.freakner;

import android.text.Editable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class User {
    @PrimaryKey(autoGenerate = false) @NonNull
    public String username ;

    public String password;

    public String nickName;

    public String image ;

    public String server;


//    public User(String username, String password, String nickName, String image, String server, List<Void> chats, List<Void> contacts) {
//        this.username = username;
//        this.password = password;
//        this.nickName = nickName;
//        this.image = image;
//        this.server = server;
//        this.chats = chats;
//        this.contacts = contacts;
//    }

    public User(String username, String password, String nickName, String server) {
        this.username = username;
        this.password = password;
        this.nickName = nickName;
        this.server = server;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", image='" + image + '\'' +
                ", server='" + server + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

}
