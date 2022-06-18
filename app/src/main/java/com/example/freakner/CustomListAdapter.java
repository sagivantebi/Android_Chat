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

public class CustomListAdapter extends ArrayAdapter<Post> {
    LayoutInflater inflater;

    public CustomListAdapter(Context ctx, ArrayList<Post> userArrayList) {
        super(ctx, R.layout.activity_contact_left_box, userArrayList);

        this.inflater = LayoutInflater.from(ctx);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Post post = getItem(position);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.activity_contact_left_box, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.contactImageLeft);
        TextView userName = convertView.findViewById(R.id.contactNameLeft);
        TextView lastMsg = convertView.findViewById(R.id.contactLastMessLeft);
        TextView time = convertView.findViewById(R.id.contactTimeLeft);

        imageView.setImageResource(R.drawable.ic_person1);
        userName.setText(post.getName());
        lastMsg.setText(post.getLast());
        time.setText(post.getLastDate());

        return convertView;
    }
}
