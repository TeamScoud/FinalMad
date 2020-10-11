package application.example.afinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHandler_3 extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    //Database Name
    private static final String DATABASE_NAME = "student_database";
    //Database Table name
    private static final String TABLE_NAME = "STUDENT";
    //Table columns
    public static final String ID = "id";
    public static final String NOTE = "name";

    private SQLiteDatabase sqLiteDatabase;

    //creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME +"("+ID+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + NOTE + " TEXT NOT NULL)";
    //Constructor

    public DBHandler_3(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

       // sqLiteDatabase.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, Notes TEXT)");
        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate (sqLiteDatabase);

    }



}
