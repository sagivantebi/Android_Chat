package com.example.freakner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Login extends AppCompatActivity {

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