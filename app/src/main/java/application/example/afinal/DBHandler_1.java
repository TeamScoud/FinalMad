package application.example.afinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler_1 extends SQLiteOpenHelper {

    public static final String DATABASE_NAME_1 = "UserInf2.db"; //
    public static final String CONTACTS_TABLE_NAME_1 = "Findateacher";
    public static final String CONTACTS_COLUMN_ID = "id";
    public static final String CONTACTS_COLUMN_NAME = "teacher";
    public static final String CONTACTS_COLUMN_EMAIL = "subject";
    public DBHandler_1(Context context) {
        super(context, DATABASE_NAME_1, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(
                "create table Findateacher " +
                        "(id integer primary key, teacher TEXT, subject TEXT)" //
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public long insertFindateacher(String teacher, String subject) { //
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues Values = new ContentValues();
        Values.put(CONTACTS_COLUMN_NAME, teacher);
        Values.put(CONTACTS_COLUMN_EMAIL, subject);


        long newRowId1 = sqLiteDatabase.insert("Findateacher", null, Values);
        return newRowId1;

    }
    public Integer deleteFindateacher(String id){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.delete(CONTACTS_TABLE_NAME_1,"id = ?",new String[] { id });
    }

    public boolean updateFindateacher(String id,String teacher,String subject){

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(CONTACTS_COLUMN_ID, id);
        values.put(CONTACTS_COLUMN_NAME, teacher);
        values.put(CONTACTS_COLUMN_EMAIL, subject);

        sqLiteDatabase.update(CONTACTS_TABLE_NAME_1, values, "id =?",new String[] { id });

        return true;
    }

    //Get user details according to the name



    public Cursor getAllDatafindateacher(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("select * from "+CONTACTS_TABLE_NAME_1,null);
        return res;
    }
    public Cursor getAllData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("select * from "+CONTACTS_TABLE_NAME_1,null);
        return res;
    }
}
