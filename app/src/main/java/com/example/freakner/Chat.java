package com.example.freakner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Chat extends AppCompatActivity {

    List<Post> listConstacts = new ArrayList<>();
    private AppDB db;
    private PostCon p;
    private ArrayAdapter<Post> adapter;
    private ListView lvContacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_chat);
            lvContacts = findViewById(R.id.listOneContact);
            db = Room.databaseBuilder(getApplicationContext(),AppDB.class,"ContactsDB").allowMainThreadQueries().build();
            p = db.postCon();
            int id = getIntent().getExtras().getInt("id");

            Post cont = p.get(id);
            listConstacts.add(cont);
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listConstacts);
            lvContacts.setAdapter(adapter);
        }
    }