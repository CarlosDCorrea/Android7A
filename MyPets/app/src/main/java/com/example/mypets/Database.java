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
    public void onUpgrade(SQLiteDatabase pets, int oldVersion, int newVersion) {
        pets.execSQL("CREATE TABLE pets (" +
                "id integer primary key autoincrement not null," +
                "name text not null," +
                "age integer," +
                "gender text," +
                "race text)"
        );
        pets.execSQL("INSERT INTO pets(name, age, gender, race)" +
                "VALUES ('Luna', '2', 'Female', 'Drandaness')");

        pets.execSQL("INSERT INTO pets(name, age, gender, race)" +
                "VALUES ('Pepo', '1', 'Male', 'Panther')");

        pets.execSQL("INSERT INTO pets(name, age, gender, race)" +
                "VALUES ('Pop', '0', 'Male', 'Ciberian Wolf')");
    }
}
