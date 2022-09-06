package com.example.sql_example;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

class DbHelper extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "STUDENT_TABLE";
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableStatement = "CREATE TABLE  STUDENT_TABLE ( StudentID Integer PRIMARY KEY AUTOINCREMENT,  STUDENT_NAME  Text, STUDENT_ROLL Text)" ;
        sqLiteDatabase.execSQL(createTableStatement);
    }

    public DbHelper(@Nullable Context context) {
        super(context, "MyDB.db", null, 1);
    }
    // this method is use to add new student to our sqlite database.
    public void addNewStudent(String stuName, String stuRoll) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put("STUDENT_NAME", stuName);
        values.put("STUDENT_ROLL", stuRoll);


        // after adding all values we are passing
        // content values to our table.
        db.insert("STUDENT_TABLE", null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }
    // we have created a new method for reading all the courses.
    public ArrayList<Student> readStudents() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<Student> studentArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                studentArrayList.add(new Student(cursorCourses.getInt(1),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3) ));
            } while (cursorCourses.moveToNext());

        }

        cursorCourses.close();
        return studentArrayList;
        /*
        // on below line we are creating a

        // readable database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorStudents = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<Student> studentArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorStudents.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                studentArrayList.add(new Student(cursorStudents.getInt(1),
                        cursorStudents.getString(2),
                        cursorStudents.getString(3)));
            } while (cursorStudents.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorStudents.close();
        return studentArrayList;
        */

    }

}