package com.example.anphoqua.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {

    public MyDBHelper(Context context) {
        super(context, "animalmanagement", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        /*
        create table animals
        (
        _id integer primary key autoincrement,
        name text,
        age integer
        )
         */

        String sql =  "create table animals " +
                "( " +
                "_id integer primary key autoincrement, " +
                "name text, " +
                "age integer" +
                ")";

        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists animals");
        onCreate(sqLiteDatabase);
    }
}


