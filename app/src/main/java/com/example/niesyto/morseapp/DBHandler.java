package com.example.niesyto.morseapp;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.view.View;

public class DBHandler extends SQLiteOpenHelper{
    //information of database
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "morseDB.db";
    public static final String TABLE_NAME = "Translation";
    public static final String COLUMN_ID = "TranslationID";
    public static final String COLUMN_BEFORE = "Before";
    public static final String COLUMN_MODE= "Mode";
    public static final String COLUMN_AFTER= "After";
    //initialize the database
    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db)  {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + COLUMN_BEFORE + " TEXT, " + COLUMN_AFTER + " TEXT, " + COLUMN_MODE + " TEXT)";
        db.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {}

    public String loadHandler() {
        String result = "";
        String query = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            int result_0 = cursor.getInt(0);
            String result_1 = cursor.getString(1);
            String result_2 = cursor.getString(2);
            String result_3 = cursor.getString(3);
            result += String.valueOf(result_0) + " " + result_1 + " " + result_2 + " " + result_3 + System.getProperty("line.separator");
        }
        cursor.close();
        db.close();
        return result;

    }

    public void addHandler(Translation translation) {
        ContentValues values = new ContentValues();

        values.put(COLUMN_BEFORE, translation.getTranslationBefore());
        values.put(COLUMN_AFTER, translation.getTranslationAfter());
        values.put(COLUMN_MODE, translation.getTranslationMode());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }


    public void dropIt(Context con){
        con.deleteDatabase(DATABASE_NAME);
    }

}
