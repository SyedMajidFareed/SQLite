package com.example.sql_example;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

class DBHelper extends SQLiteOpenHelper {

    public static final String STUDENT_ID = "StudentID";
    public static final String STUDENT_NAME = "StudentName";
    public static final String STUDENT_ROLL = "StudentRollNumber";
    public static final String STUDENT_TABLE = "StudentTable";


    public DBHelper(@Nullable Context context) {
        super(context, "MyDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //String createTableSTatementOne = "CREATE TABLE CustTable(CustomerID Integer PRIMARY KEY AUTOINCREMENT, " + CUSTOMER_NAME_FIRST + " Text, CustomerAge Int, ActiveCustomer BOOL) ";
        String createTableSTatement = "CREATE TABLE " + STUDENT_TABLE + "(" +
                STUDENT_ID + " Integer PRIMARY KEY AUTOINCREMENT, " + STUDENT_NAME + " Text, "
                + STUDENT_ROLL + " Int) ";
        db.execSQL(createTableSTatement);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE);
        onCreate(db);
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
        values.put(STUDENT_NAME, stuName);
        values.put(STUDENT_ROLL, stuRoll);


        // after adding all values we are passing
        // content values to our table.
        db.insert(STUDENT_TABLE, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }
    // we have created a new method for reading all the students.
    public ArrayList<Student> readStudents() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + STUDENT_TABLE, null);

        ArrayList<Student> studentArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                studentArrayList.add(new Student(cursorCourses.getInt(0),
                        cursorCourses.getString(1),
                        cursorCourses.getString(2)));

            } while (cursorCourses.moveToNext());
        }

        cursorCourses.close();
        return studentArrayList;


    }
    public void Delete(String Roll) {
        SQLiteDatabase db = this.getReadableDatabase();
        String deleteQuery = "DELETE FROM " + STUDENT_TABLE + " WHERE " + STUDENT_ROLL + " = " + Roll;
        db.execSQL(deleteQuery);
        db.close();
    }
    public void Update(String stuName, String stuRoll, String stuRollOriginal) {
        SQLiteDatabase db = this.getWritableDatabase();

        String UpdateQuery = "UPDATE " + STUDENT_TABLE + " SET " + STUDENT_NAME + " = " +"'"+stuName+"' "+" , "+ STUDENT_ROLL +" = "+"'"+stuRoll+"' "+ " WHERE "+STUDENT_ROLL+" ="+ "'"+stuRollOriginal+"' ";

        db.execSQL(UpdateQuery);
        db.close();
    }
}