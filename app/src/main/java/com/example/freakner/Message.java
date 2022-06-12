package com.example.freakner;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Message {
    @PrimaryKey(autoGenerate=true)
    public int id;
    public String Content;
    public String Type;
    public String Created;
    public Boolean Sent;
    public String User1;
    public String User2;

    public Message() {
    }

    public Message(int id, String content, String type, String created, Boolean sent, String user1, String user2) {
        id = id;
        Content = content;
        Type = type;
        Created = created;
        Sent = sent;
        User1 = user1;
        User2 = user2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getCreated() {
        return Created;
    }

    public void setCreated(String created) {
        Created = created;
    }

    public Boolean getSent() {
        return Sent;
    }

    public void setSent(Boolean sent) {
        Sent = sent;
    }

    public String getUser1() {
        return User1;
    }

    public void setUser1(String user1) {
        User1 = user1;
    }

    public String getUser2() {
        return User2;
    }

    public void setUser2(String user2) {
        User2 = user2;
    }

    @Override
    public String toString() {
        return  this.Content;
    }
}
