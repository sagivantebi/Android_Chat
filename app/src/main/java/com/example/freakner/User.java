package com.example.freakner;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;
@Entity
public class User {
    @PrimaryKey(autoGenerate = false)
    public String username ;

    public String password;

    public String nickName;

    public String image ;

    public String server;

    public List<Void> chats;
    public List<Void> contacts;

    public User() {
    }

    public User(String username, String password, String nickName, String image, String server, List<Void> chats, List<Void> contacts) {
        this.username = username;
        this.password = password;
        this.nickName = nickName;
        this.image = image;
        this.server = server;
        this.chats = chats;
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", image='" + image + '\'' +
                ", server='" + server + '\'' +
                ", chats=" + chats +
                ", contacts=" + contacts +
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

    public List<Void> getChats() {
        return chats;
    }

    public void setChats(List<Void> chats) {
        this.chats = chats;
    }

    public List<Void> getContacts() {
        return contacts;
    }

    public void setContacts(List<Void> contacts) {
        this.contacts = contacts;
    }
}
