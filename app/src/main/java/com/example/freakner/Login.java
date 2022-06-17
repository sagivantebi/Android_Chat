package com.example.freakner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.iid.FirebaseInstanceId;

import java.util.ArrayList;
import java.util.List;

import api.PostAPI;
//import viewodels.PostsViewModel;

public class Login extends AppCompatActivity {
//    private PostsViewModel viewModel;
    List<User> listConstacts = new ArrayList<>();
    private UserCon p;
    private ArrayAdapter<User> adapter;
    private ListView lvContacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnNotRegister = findViewById(R.id.btnNotRegister);
        Button btnLogin = findViewById(R.id.btnLogin);
        btnNotRegister.setOnClickListener(v -> {
            Intent i = new Intent(this,Registration.class);
            startActivity(i);
        });

        btnLogin.setOnClickListener(v -> {
            Intent i = new Intent(this,Contacts.class);
            startActivity(i);
        });


        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(Login.this,instanceIdResult -> {
            String newToken = instanceIdResult.getToken();
        });
//        PostAPI postAPI = new PostAPI();
//        postAPI.get();
//        lvContacts = findViewById(R.id.listUsers);
//        db = Room.databaseBuilder(getApplicationContext(),AppDB.class,"ContactsDB4").allowMainThreadQueries().build();
//        p = db.postCon();

        Log.i("hi","hi");


    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}