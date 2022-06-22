package com.example.freakner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomListAdapterChat extends ArrayAdapter<Post> {
    LayoutInflater inflater;

    public CustomListAdapterChat(Context ctx, ArrayList<Post> userArrayList) {
        super(ctx, R.layout.activity_contact_chat, userArrayList);

        this.inflater = LayoutInflater.from(ctx);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Post post = getItem(position);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.activity_contact_chat, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.contactImageChat);
        TextView userName = convertView.findViewById(R.id.contactNameChat);

        imageView.setImageResource(R.drawable.ic_person1);
        userName.setText(post.getName());

        return convertView;
    }
}
