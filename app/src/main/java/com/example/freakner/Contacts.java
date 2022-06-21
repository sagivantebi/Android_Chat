package com.example.freakner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
//import adapters.PostListAdapter;
import api.PostAPI;
import api.UserAPI;

//import viewodels.PostsViewModel;

public class Contacts extends AppCompatActivity {
    ArrayList<Post> listConstacts = new ArrayList<>();
    private AppDB db;
    private PostCon p;
    private ArrayAdapter<Post> adapter;
    private ListView lvContacts;
    String username;
//    private PostListAdapter adapterRec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        this.lvContacts = findViewById(R.id.ListViewContacts);
        String username = getIntent().getStringExtra("username");
        this.username = username;
        db = Room.databaseBuilder(getApplicationContext(),AppDB.class,"ContactsDB5").allowMainThreadQueries().build();
        p = db.postCon();
        com.google.android.material.floatingactionbutton.FloatingActionButton btnAddContact = findViewById(R.id.btnAddContact);
        btnAddContact.setOnClickListener(v -> {
            Intent i = new Intent(this,AddForm.class).putExtra("username", username);
            startActivity(i);
        });

//        PostAPI postAPI = new PostAPI();
//        postAPI.get();
//        Log.i("hi","hi");

        UserAPI userAPI = new UserAPI();
        userAPI.getUser(getApplicationContext(), db.userCon(), db.mesCon(), db.postCon(), username);

        ImageView imageSetting = findViewById(R.id.imageSetting);
        imageSetting.setOnClickListener(v -> {
            Intent i = new Intent(this,Settings.class);
            startActivity(i);
        });

        this.listConstacts = (ArrayList<Post>) p.getContacts(username);
        this.adapter = new CustomListAdapter(getApplicationContext(), listConstacts);

        this.lvContacts.setAdapter(this.adapter);

       this.lvContacts.setOnItemLongClickListener((adapterView,view,i,l) ->{
            Post post = listConstacts.remove(i);
            p.delete(post);
            adapter.notifyDataSetChanged();
            return true;
        });

        this.lvContacts.setOnItemClickListener((adapterView,view,i,l) ->{
            Intent intent = new Intent(this, ChatScreen.class);
            intent.putExtra("id",listConstacts.get(i).getId());
            intent.putExtra("username", username).putExtra("contact", listConstacts.get(i).getName());
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
        listConstacts.addAll(p.getContacts(this.username));
        adapter.notifyDataSetChanged();
//        adapterRec.notifyDataSetChanged();

    }

}