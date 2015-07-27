package com.kastenoriginal.obesencek.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.kastenoriginal.obesencek.Word;

import java.util.ArrayList;

public class DatabaseDataProvider {

    private SQLHelper sqlHelper;
    private SQLiteDatabase db;

    public DatabaseDataProvider(Context context) {
        sqlHelper = new SQLHelper(context);
    }

    public void open() {
        try {
            db = sqlHelper.getWritableDatabase();
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        sqlHelper.close();
    }

    public void insertWord(Word word) {
        open();
        ContentValues words = new ContentValues();
        words.put(SQLHelper.COLUMN_WORD_TITLE, word.getWordTitle());
        words.put(SQLHelper.COLUMN_WORD_LENGTH, word.getWordLength());
        db.insert(SQLHelper.TABLE_WORDS, null, words);
        close();
    }

    public void removeWord(Word word) {
        open();
        db.delete(
                SQLHelper.TABLE_WORDS,
                SQLHelper.COLUMN_ID + " = ?",
                new String[]{"" + word.getWordId()});
        close();
    }

    public ArrayList<Word> getWords() {
        open();
        @SuppressLint("Recycle") Cursor c = db.query(SQLHelper.TABLE_WORDS, null, null, null, null, null, null);
        ArrayList<Word> words = new ArrayList<>();
        if (c != null && c.moveToFirst()) {
            do {
                Word word = new Word(
                        c.getString(c.getColumnIndex(SQLHelper.COLUMN_WORD_TITLE)),
                        c.getString(c.getColumnIndex(SQLHelper.COLUMN_WORD_LENGTH)));
                word.setWordId(c.getInt(c.getColumnIndex(SQLHelper.COLUMN_ID)));
                words.add(word);
            } while (c.moveToNext());
        }
        close();
        return words;
    }
}
