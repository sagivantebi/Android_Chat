package com.example.freakner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddForm extends AppCompatActivity {

    private AppDB db;
    private PostCon p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_form);

        db = Room.databaseBuilder(getApplicationContext(),AppDB.class,"ContactsDB").allowMainThreadQueries().build();
        p = db.postCon();

        Button addFormButton = findViewById(R.id.addFormButton);
        addFormButton.setOnClickListener(v -> {
            EditText editText = findViewById(R.id.addFormUsername);
            Post post = new Post(0,editText.getText().toString());
            p.insert(post);
            finish();
        });
    }
}