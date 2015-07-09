package com.kastenoriginal.obesencek.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "Obesencek.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_WORDS = "words";

    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_WORD = "";


    private static final String DATABASE_CREATE = "create table "
            + TABLE_WORDS + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_WORD
            + " text not null);";

    public SQLHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORDS);
        onCreate(db);
    }
}
