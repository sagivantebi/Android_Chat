package com.example.freakner;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import api.Mess;

@Entity
public class Message {
    @PrimaryKey(autoGenerate=true)
    public int id;
    public String Content;
    public String Type;
    public String Created;
    public Boolean Sent;
//    public String User1;
//    public String User2;
    public int chatId;

    public Message() {
    }

    public Message(int Id, String Content, String Type, String Created, Boolean Sent) {
        this.id = Id;
        this.Content = Content;
        this.Type = Type;
        this.Created = Created;
        this.Sent = Sent;
    }

    public Message(String content, String type, Boolean sent, int chatId) {
        Content = content;
        Type = type;
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
        String date = df.format(Calendar.getInstance().getTime());
        Created = date;
        Sent = sent;
        this.chatId = chatId;
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

    @Override
    public String toString() {
        return  this.Content;
    }
}
