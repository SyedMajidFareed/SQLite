package com.example.sql_example;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.database.sqlite.SQLiteOpenHelper;

class DbHelper extends SQLiteOpenHelper{

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableStatement = "CREATE TABLE  STUDENT_TABLE ( StudentID Integer PRIMARY KEY AUTOINCREMENT,  STUDENT_NAME  Text, ACTIVE_STUDENT  BOOL)" ;
        sqLiteDatabase.execSQL(createTableStatement);
    }

    public DbHelper(@Nullable Context context) {
        super(context, "MyDB.db", null, 1);
    }

}
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}