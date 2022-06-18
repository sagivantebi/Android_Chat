package com.example.freakner;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class Chat {
    @PrimaryKey
    public int id;
    public String contactId;
    public ArrayList<Message> messages;

    public Chat(int id, String PostId) {
        this.id = id;
        this.contactId = PostId;
        this.messages = new ArrayList<Message>();
    }

    public int getId() {
        return id;
    }

    public String getContact_id() {
        return contactId;
    }


    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", contact_id='" + contactId + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContact_id(String contact_id) {
        this.contactId = contact_id;
    }


}
