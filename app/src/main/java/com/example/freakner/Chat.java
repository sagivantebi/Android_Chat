package com.example.freakner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Chat extends AppCompatActivity {

    List<Post> listConstacts = new ArrayList<>();
    List<Message> listMessages = new ArrayList<>();
    private AppDB db;
    private PostCon p;
    private MesCon m;
    private ArrayAdapter<Post> adapter;
    private ArrayAdapter<Message> adapterMessage;
    private ListView lvContacts;
    private ListView lvMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        lvContacts = findViewById(R.id.listOneContact);
        lvMessages = findViewById(R.id.ListViewMessages);
        db = Room.databaseBuilder(getApplicationContext(), AppDB.class, "ContactsDB4").allowMainThreadQueries().build();
        p = db.postCon();
        m = db.mesCon();
        int id = getIntent().getExtras().getInt("id");

        listMessages = m.index();
        adapterMessage = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listMessages);
        lvMessages.setAdapter(adapterMessage);

        Button btn_sendMessage = findViewById(R.id.btn_sendMessage);
        btn_sendMessage.setOnClickListener(v -> {
            EditText editText = findViewById(R.id.new_message);
            Message message = new Message(0, editText.getText().toString(), "text", "date", true, "", "");
            m.insert(message);
            adapterMessage.notifyDataSetChanged();
            Intent intent = new Intent(this,Chat.class);
            intent.putExtra("id",id);
            startActivity(intent);
        });

        lvMessages.setOnItemLongClickListener((adapterView,view,i,l) ->{
            Message message = listMessages.remove(i);
            m.delete(message);
            adapterMessage.notifyDataSetChanged();
            return true;
        });

        Post cont = p.get(id);
        listConstacts.add(cont);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listConstacts);
        lvContacts.setAdapter(adapter);
    }
    @Override
    protected void onResume() {
        super.onResume();
        listMessages.clear();
        listMessages.addAll(m.index());
        adapterMessage.notifyDataSetChanged();

    }
}