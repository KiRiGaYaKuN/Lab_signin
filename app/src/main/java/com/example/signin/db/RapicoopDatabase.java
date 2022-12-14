package com.example.signin.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class RapicoopDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="Rapicoop.db";
    public static final int DATABASE_VERSION=1;
    public static final String TABLE_NAME="t_usuarios";

    public RapicoopDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " +TABLE_NAME+ "(id INTEGER PRIMARY KEY AUTOINCREMENT,usuario TEXT,"
                + "nombres TEXT,apellidos TEXT,correo TEXT,telefono TEXT,password TEXT,rol TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE " + TABLE_NAME);
        onCreate(db);
    }
}
