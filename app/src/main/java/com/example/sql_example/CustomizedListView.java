package com.example.sql_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomizedListView extends AppCompatActivity {
    // creating variables for our array list,
    // dbhandler, adapter and recycler view.
    private ArrayList<Student> courseModalArrayList;
    private DbHelper dbHandler;
    private MyViewAdapter courseRVAdapter;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customized_list_view);

        // initializing our all variables.
        courseModalArrayList = new ArrayList<>();
        dbHandler = new DbHelper(CustomizedListView.this);

        // getting our student array
        // list from db handler class.
        courseModalArrayList = dbHandler.readStudents();

        // on below line passing our array lost to our adapter class.
        courseRVAdapter = new MyViewAdapter(CustomizedListView.this, courseModalArrayList);
        list = findViewById(R.id.list1);



        // setting our adapter to recycler view.
        list.setAdapter(courseRVAdapter);

    }
}