package com.example.freakner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
//import adapters.PostListAdapter;
import api.PostAPI;

//import viewodels.PostsViewModel;

public class Contacts extends AppCompatActivity {
    ArrayList<Post> listConstacts = new ArrayList<>();
    private AppDB db;
    private PostCon p;
    private ArrayAdapter<Post> adapter;
    private ListView lvContacts;
//    private PostListAdapter adapterRec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        lvContacts = findViewById(R.id.ListViewContacts);

        db = Room.databaseBuilder(getApplicationContext(),AppDB.class,"ContactsDB4").allowMainThreadQueries().build();
        p = db.postCon();
        com.google.android.material.floatingactionbutton.FloatingActionButton btnAddContact = findViewById(R.id.btnAddContact);
        btnAddContact.setOnClickListener(v -> {
            Intent i = new Intent(this,AddForm.class);
            startActivity(i);
        });

        PostAPI postAPI = new PostAPI();
        postAPI.get();
        Log.i("hi","hi");


        ImageView imageSetting = findViewById(R.id.imageSetting);
        imageSetting.setOnClickListener(v -> {
            Intent i = new Intent(this,Settings.class);
            startActivity(i);
        });

        listConstacts = (ArrayList<Post>) p.index();
        adapter = new CustomListAdapter(getApplicationContext(), listConstacts);
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


        //new from 17/6 - RecyclerView
//        RecyclerView lsPosts = findViewById(R.id.recyclePostContacts);
//        adapterRec = new PostListAdapter(this);
//        lsPosts.setAdapter(adapterRec);
//        lsPosts.setLayoutManager(new LinearLayoutManager(this));
//        adapterRec.setPosts(listConstacts);
//
//        lsPosts.setOnLongClickListener((adapterView,view,i,l) ->{
//            Post post = listConstacts.remove(i);
//            p.delete(post);
//            adapterRec.notifyDataSetChanged();
//            return true;
//        });
//
//        ItemClickSupport.addTo(lsPosts)
//                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
//                    @Override
//                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
//                        Intent intent = new Intent(this,Chat.class);
//                        intent.putExtra("id",listConstacts.get(i).getId());
//                        startActivity(intent);
//                    }
//
//                });
//
//        lsPosts.setOnClickListener((adapterView,view,i,l) ->{
//            Intent intent = new Intent(this,Chat.class);
//            intent.putExtra("id",listConstacts.get(i).getId());
//            startActivity(intent);
//        });
        // till now
    }


    @Override
    protected void onResume() {
        super.onResume();
        listConstacts.clear();
        listConstacts.addAll(p.index());
        adapter.notifyDataSetChanged();
//        adapterRec.notifyDataSetChanged();

    }

}