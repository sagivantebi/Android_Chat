package com.example.freakner;

import android.widget.ImageView;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Entity
public class Post {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String Name ;
    public String Last;
    public String server;
    public String LastDate;

    public Post(String name, String last, String server) {
        this.Name = name;
        this.Last = last;
        this.server = server;
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
        String date = df.format(Calendar.getInstance().getTime());
        this.LastDate = date;

    }

    public Post() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLast() {
        return Last;
    }

    public void setLast(String last) {
        Last = last;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getLastDate() {
        return LastDate;
    }

    public void setLastDate(String lastDate) {
        LastDate = lastDate;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Last='" + Last + '\'' +
                ", server='" + server + '\'' +
                ", LastDate='" + LastDate + '\'' +
                '}';
    }
}
