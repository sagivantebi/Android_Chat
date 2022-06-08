package com.example.freakner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Button saveNewNickname = findViewById(R.id.saveNewNickname);
        saveNewNickname.setOnClickListener(v -> {
            Intent i = new Intent(this, Contacts.class);
            startActivity(i);
        });
    }
}