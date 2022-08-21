package com.example.sql_example;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

class MyViewAdapter extends ArrayAdapter<Student> {
    public MyViewAdapter(@NonNull Context context, ArrayList<Student> studentArrayList) {
        super(context, 0, studentArrayList);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Student student = getItem(position);
        convertView = LayoutInflater.from(getContext()). inflate(R.layout.activity_customized_list_view, parent, false);
        TextView textViewName = convertView.findViewById(R.id.textView7);
        TextView textViewCampus = convertView.findViewById(R.id.textView8);
        textViewName.setText(student.getStudent_Name());
        textViewCampus.setText(student.getStudent_Roll());
        return convertView;
    }
}