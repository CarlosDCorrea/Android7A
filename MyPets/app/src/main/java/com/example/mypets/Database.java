package com.example.mypets;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper{
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase pets) {
        //create user tables
        pets.execSQL("CREATE TABLE users (" +
                "id integer primary key autoincrement not null," +
                "email text unique not null," +
                "password text not null," +
                "firstname text," +
                "lastname text," +
                "mobile text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
