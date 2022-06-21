package com.example.freakner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import api.PostAPI;
import api.UserAPI;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Button btnRegisterAlready = findViewById(R.id.btnRegisterAlready);
        btnRegisterAlready.setOnClickListener(v -> {
            finish();
        });

        Button btn_Register = findViewById(R.id.btn_Register);
        btn_Register.setOnClickListener(v -> {
            EditText username = findViewById(R.id.reg_Username);
            EditText nickname = findViewById(R.id.reg_Nickname);
            EditText password = findViewById(R.id.reg_Password);
            EditText re_password = findViewById(R.id.reg_Password_ver);
            AppDB db = Room.databaseBuilder(getApplicationContext(),AppDB.class,"ContactsDB6").allowMainThreadQueries().build();
            UserCon p = db.userCon();
            if(p.get(username.getText().toString()) != null){
                Context context = getApplicationContext();
                Toast.makeText(context, "username already exists", Toast.LENGTH_LONG).show();
                return;
            }
            User newUser = new User(username.getText().toString(), password.getText().toString(), nickname.getText().toString(), "", "s1");
            insertUser(p,  newUser);
            finish();
        });
    }
    void insertUser(UserCon p, User u) {
        UserAPI userAPI = new UserAPI();
        userAPI.addUser(getApplicationContext(), u);
        p.insert(u);
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