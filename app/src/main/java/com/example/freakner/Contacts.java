package com.example.freakner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Contacts extends AppCompatActivity {
    List<Post> listConstacts = new ArrayList<>();
    private AppDB db;
    private PostCon p;
    private ArrayAdapter<Post> adapter;
    private ListView lvContacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        lvContacts = findViewById(R.id.ListViewContacts);
        db = Room.databaseBuilder(getApplicationContext(),AppDB.class,"ContactsDB").allowMainThreadQueries().build();
        p = db.postCon();
        com.google.android.material.floatingactionbutton.FloatingActionButton btnAddContact = findViewById(R.id.btnAddContact);
        btnAddContact.setOnClickListener(v -> {
            Intent i = new Intent(this,AddForm.class);
            startActivity(i);
        });

        ImageView imageSetting = findViewById(R.id.imageSetting);
        imageSetting.setOnClickListener(v -> {
            Intent i = new Intent(this,Settings.class);
            startActivity(i);
        });

        listConstacts = p.index();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listConstacts);
        lvContacts.setAdapter(adapter);

        lvContacts.setOnItemLongClickListener((adapterView,view,i,l) ->{
            Post post = listConstacts.remove(i);
            p.delete(post);
            adapter.notifyDataSetChanged();
            return true;
        });

        lvContacts.setOnItemClickListener((adapterView,view,i,l) ->{
            Intent intent = new Intent(this,Chat.class);
            intent.putExtra("id",listConstacts.get(i).getId());
            startActivity(intent);
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        listConstacts.clear();
        listConstacts.addAll(p.index());
        adapter.notifyDataSetChanged();

    }

}