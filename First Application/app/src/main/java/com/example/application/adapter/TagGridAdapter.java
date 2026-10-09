package com.example.application.adapter;


import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.application.R;

public class TagGridAdapter extends ArrayAdapter<String> {

    String[] tag;
    Context context;

    public TagGridAdapter(@NonNull Context context,String[] tag) {
        super(context, R.layout.item_tag);

        this.tag = tag;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_tag,parent,false);
        TextView tvTagTitle = view.findViewById(R.id.tvTagTitle);
        tvTagTitle.setText(tag[position]);

        return view;


    }
}