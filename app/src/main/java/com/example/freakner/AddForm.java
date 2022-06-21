package com.example.freakner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import api.Cont;
import api.PostAPI;

public class AddForm extends AppCompatActivity {

    private AppDB db;
    private PostCon p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_form);
        String username = getIntent().getStringExtra("username");
        db = Room.databaseBuilder(getApplicationContext(),AppDB.class,"ContactsDB6").allowMainThreadQueries().build();
        p = db.postCon();

        Button addFormButton = findViewById(R.id.addFormButton);
        addFormButton.setOnClickListener(v -> {
            EditText editText = findViewById(R.id.addFormUsername);
            if(db.userCon().find(editText.getText().toString()) == null){
                Toast toast = Toast.makeText(getApplicationContext(), "Contact not found", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return;
            }
            Post post = new Post(editText.getText().toString(),"Hi","s1", username);
            p.insert(post);
            PostAPI postAPI = new PostAPI();
            postAPI.addContact(getApplicationContext(), username, new Cont(post.getName(), post.getName(), post.getServer()));
            finish();
        });
    }
}