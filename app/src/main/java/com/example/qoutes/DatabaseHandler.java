package com.example.qoutes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String db = "qoute.db";
    private static final String tb = "dqoute";

    public DatabaseHandler(@Nullable Context context) {
        super(context, db, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+tb+" (SRNO INTEGER PRIMARY KEY AUTOINCREMENT, QOUTE TEXT,AUTHOR TEXT, LIKED TEXT) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+tb);
    }

    public String addliked(String qoute,String author,String like)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues con = new ContentValues();
        con.put("QOUTE",qoute);
        con.put("AUTHOR",author);
        con.put("LIKED", like);

        long result = db.insert(tb, null, con);
        if (result == -1) {
            return "failed";
        } else {
            return "LIKED";
        }
    }

    public String delliked(String qoute)
    {
        SQLiteDatabase db = getWritableDatabase();
        String whereclause = " QOUTE=?";
        String[] whereselection = {qoute};
        long res = db.delete(tb,whereclause,whereselection);
        if(res!=-1)
        {
            return "UNLIKED";
        }
        else {
            return "notdeleted";
        }
    }

    public Cursor getAll()
    {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+tb,null);
        return cursor;
    }




}
