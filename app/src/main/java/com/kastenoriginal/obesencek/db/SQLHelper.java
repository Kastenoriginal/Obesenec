package com.kastenoriginal.obesencek.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Obesencek.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_WORDS = "words";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_WORD_TITLE = "title";
    public static final String COLUMN_WORD_LENGTH = "length";


    private static final String CREATE_TABLE_WORDS =
            "CREATE TABLE IF NOT EXISTS" + TABLE_WORDS + " ("
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_WORD_TITLE + " text not null);"
            + COLUMN_WORD_LENGTH + "text not null";

    public SQLHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_WORDS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORDS);
        onCreate(db);
    }
}
