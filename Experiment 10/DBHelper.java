package com.example.sqldisplay;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "StudentDB";

    public DBHelper(Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE students(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "course TEXT)");

        // Sample Data
        db.execSQL("INSERT INTO students(name,course) " +
                "VALUES('Shrutika','MCA')");

        db.execSQL("INSERT INTO students(name,course) " +
                "VALUES('Suyash','BCA')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion,
                          int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS students");
        onCreate(db);
    }

    // Fetch Data
    public Cursor getData() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(
                "SELECT * FROM students",
                null);

        return cursor;
    }
}