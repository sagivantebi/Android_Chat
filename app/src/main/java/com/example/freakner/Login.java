package com.example.freakner;

import static com.example.freakner.MyApplication.context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

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

        EditText username = findViewById(R.id.editTextTextPersonName);
        EditText password = findViewById(R.id.editTextTextPassword);

        btnNotRegister.setOnClickListener(v -> {
            Intent i = new Intent(this,Registration.class);
            startActivity(i);
        });

        btnLogin.setOnClickListener(v -> {
            AppDB db = Room.databaseBuilder(getApplicationContext(),AppDB.class,"ContactsDB5").allowMainThreadQueries().build();
            UserCon p = db.userCon();
            Context context = getApplicationContext();

            User attempted = p.get(username.getText().toString());
            if(attempted == null){
                Toast.makeText(context, "No such Username", Toast.LENGTH_LONG).show();
                return;
            }
            if(!attempted.password.equals(password.getText().toString())){
                Toast.makeText(context, "Wrong password", Toast.LENGTH_LONG).show();
                return;
            }
            Intent i = new Intent(this,Contacts.class).putExtra("username", username.getText().toString());
            startActivity(i);
        });


        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(Login.this,instanceIdResult -> {
            String newToken = instanceIdResult.getToken();
        });
//        PostAPI postAPI = new PostAPI();
//        postAPI.get();
//        lvContacts = findViewById(R.id.listUsers);
//        db = Room.databaseBuilder(getApplicationContext(),AppDB.class,"ContactsDB5").allowMainThreadQueries().build();
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