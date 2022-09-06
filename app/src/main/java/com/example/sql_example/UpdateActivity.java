package com.example.sql_example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    String origRoll;
    String StudentName;
    String Studentrollnum;
    EditText nameText,rollnumberText;
    Button doneBtn, cancelBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Intent intent= getIntent();
        StudentName = intent.getStringExtra("name");
        Studentrollnum = intent.getStringExtra("roll");
        origRoll = intent.getStringExtra("roll");
        nameText = findViewById(R.id.upNametxt);
        rollnumberText = findViewById(R.id.upRolltxt);
        doneBtn = findViewById(R.id.Donebtn);
        cancelBtn = findViewById(R.id.Cancelbtn);
        //setting the editText
        nameText.setText(StudentName);
        rollnumberText.setText(Studentrollnum);
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // below line is to get data from all edit text fields.
                String studentName = nameText.getText().toString();
                String studentRoll = rollnumberText.getText().toString();
                // validating if the text fields are empty or not.
                if (studentName.isEmpty() && studentRoll.isEmpty()) {
                    Toast.makeText(UpdateActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }
                DBHelper dbHandler = new DBHelper(UpdateActivity.this);
                // on below line we are calling a method to add new
                // student to sqlite data and pass all our values to it.
                dbHandler.Update(studentName, origRoll, studentRoll);

                // after adding the data we are displaying a toast message.
                Toast.makeText(UpdateActivity.this, "Student has been Updated.", Toast.LENGTH_SHORT).show();
                nameText.setText("");
                rollnumberText.setText("");
            }
        });
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateActivity.this.finish();
            }
        });
    }
}