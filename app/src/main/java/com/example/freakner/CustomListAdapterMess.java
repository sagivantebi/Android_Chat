package com.example.freakner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomListAdapterMess extends ArrayAdapter<Message> {
    LayoutInflater inflater;
    String usernameMe;
    String contactName;

    public CustomListAdapterMess(Context ctx, ArrayList<Message> userArrayList,String usernameMe,String contactName) {
        super(ctx, R.layout.activity_contact_mess_left, userArrayList);
        this.usernameMe = usernameMe;
        this.contactName = contactName;
        this.inflater = LayoutInflater.from(ctx);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Message message = getItem(position);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.activity_contact_mess_left, parent, false);
        }
        TextView message_content = convertView.findViewById(R.id.message_contact_left);
        message_content.setText(message.getContent());
        TextView userName = convertView.findViewById(R.id.username_message);
        TextView time = convertView.findViewById(R.id.message_contact_time);
        time.setText(message.getCreated());

        if (message.getSent())
            userName.setText(this.usernameMe);
        else
            userName.setText(this.contactName);

        return convertView;
    }
}
