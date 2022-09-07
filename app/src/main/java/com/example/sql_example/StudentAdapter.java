package com.example.sql_example;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter<Student> {
    private Context context;
    public StudentAdapter(@NonNull Context context, ArrayList<Student> ListViewArray) {
        super(context, R.layout.customlistview, ListViewArray);
        this.context = context;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Student list = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.customlistview, parent, false);
        TextView Name = convertView.findViewById(R.id.Name);
        TextView Rollnum = convertView.findViewById(R.id.RollNum);
        Button del = convertView.findViewById(R.id.delete);
        Button Update = convertView.findViewById(R.id.Edit);
        ImageView img = convertView.findViewById(R.id.img);
        Name.setText(list.getStudent_Name());
        String name = list.getStudent_Name();
        String roll=list.getStudent_Roll();
        Rollnum.setText(list.getStudent_Roll());
        img.setImageResource(R.drawable.profile);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBHelper dbHelper = new DBHelper(getContext());
                dbHelper.Delete(roll);
                remove(list);
            }
        });
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(context, UpdateActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("roll",roll);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}