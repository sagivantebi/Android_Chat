package com.example.freakner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Button btnRegisterAlready = findViewById(R.id.btnRegisterAlready);
        btnRegisterAlready.setOnClickListener(v -> {
            Intent i = new Intent(this, Login.class);
            startActivity(i);
        });

        Button btn_Register = findViewById(R.id.btn_Register);
        btn_Register.setOnClickListener(v -> {
            Intent i = new Intent(this, Login.class);
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