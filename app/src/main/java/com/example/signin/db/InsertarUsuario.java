package com.example.signin.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;


import java.util.ArrayList;

public class InsertarUsuario extends RapicoopDatabase{

    Context context;
    public InsertarUsuario(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long nuevoUsuario (String usuario, String nombres, String apellidos, String correo, String telefono, String contrasena, String rol){

        long id = 0;

        try {

            RapicoopDatabase rapidb = new RapicoopDatabase(context);
            SQLiteDatabase db = rapidb.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("usuario", usuario);
            values.put("nombres", nombres);
            values.put("apellidos", apellidos);
            values.put("correo", correo);
            values.put("telefono", telefono);
            values.put("password", contrasena);
            values.put("rol", rol);

            id = db.insert(TABLE_NAME, null, values);
        }catch (Exception ex){
            ex.toString();
        }

        return id;
    }


    public String devolver(String user){

        RapicoopDatabase rapidb = new RapicoopDatabase(context);
        SQLiteDatabase db = rapidb.getWritableDatabase();
        Cursor cursorUsuarios = null;
        String rol = "nada";

        cursorUsuarios = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE usuario LIKE '" + user + "'",null);

        cursorUsuarios.moveToFirst();
        rol = cursorUsuarios.getString(7);

        return rol;
    }

    public Boolean verificar(String psw, String user){

        RapicoopDatabase rapidb = new RapicoopDatabase(context);
        SQLiteDatabase db = rapidb.getWritableDatabase();
        Cursor cursorUsuarios = null;
        String rol = null;

        cursorUsuarios = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE usuario LIKE '" + user + "' AND password LIKE '" + psw + "'",null);


        return cursorUsuarios.moveToFirst();
    }


}
