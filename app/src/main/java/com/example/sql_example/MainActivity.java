package com.example.sql_example;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // creating variables for our edittext, button and dbhelper

    private EditText studentNameEdt, studentRollEdt;
    private Button addStudentBtn, viewAllStudentsBtn;
    private DBHelper dbHandler;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentNameEdt = findViewById(R.id.editTextName);
        studentRollEdt = findViewById(R.id.editTextRollNumber);
        addStudentBtn = findViewById(R.id.buttonAdd);
        viewAllStudentsBtn = findViewById(R.id.buttonViewAll);
        listView = findViewById(R.id.listViewStudent);


        // creating a new dbhelper class
        // and passing our context to it.
        dbHandler = new DBHelper(MainActivity.this);

        //onClickListeners
        addStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // below line is to get data from all edit text fields.
                String studentName = studentNameEdt.getText().toString();
                String studentRoll = studentRollEdt.getText().toString();

                // validating if the text fields are empty or not.
                if (studentName.isEmpty() && studentRoll.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // student to sqlite data and pass all our values to it.
                dbHandler.addNewStudent(studentName, studentRoll);

                // after adding the data we are displaying a toast message.
                Toast.makeText(MainActivity.this, "Student has been added.", Toast.LENGTH_SHORT).show();
                studentNameEdt.setText("");
                studentRollEdt.setText("");
            }
        });

        viewAllStudentsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*                List<Student> list = dbHandler.readStudents();
               ArrayAdapter arrayAdapter = new ArrayAdapter<Student>
                        (MainActivity.this, android.R.layout.simple_list_item_1,list);
                listView.setAdapter(arrayAdapter);

 */
                ArrayList<Student> list =  dbHandler.readStudents();

                StudentAdapter adapter = new StudentAdapter(getBaseContext(), list);
                ListView listView = findViewById(R.id.listViewStudent);
                listView.setAdapter(adapter);


            }
        });
    }
}