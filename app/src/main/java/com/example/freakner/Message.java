package com.example.freakner;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Entity
public class Message {
    @PrimaryKey(autoGenerate=true)
    public int id;
    public String content;
    public String type;
    public String created;
    public Boolean sent;
//    public String User1;
//    public String User2;
    public int chatId;

    public Message() {
    }

    public Message(int id, String content, String type, String created, Boolean sent) {
        this.id = id;
        this.content = content;
        this.type = type;
        this.created = created;
        this.sent = sent;
    }
    public Message(Message m) {
        this.id = m.id;
        this.content = m.content;
        this.type = m.type;
        this.created = m.created;
        this.sent = m.sent;
    }

    public Message(String content, String type, Boolean sent, int chatId) {
        this.content = content;
        this.type = type;
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
        String date = df.format(Calendar.getInstance().getTime());
        created = date;
        this.sent = sent;
        this.chatId = chatId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Boolean getSent() {
        return sent;
    }

    public void setSent(Boolean sent) {
        this.sent = sent;
    }

    @Override
    public String toString() {
        return  this.content;
    }
}
