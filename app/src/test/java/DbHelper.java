import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

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

}