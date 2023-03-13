package com.example.sqlite.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Dbhelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "pruebita.db";
    private String TABLE_CARRO = "t.carro";
    public Dbhelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE "+ TABLE_CARRO + "(" +
                    "placa INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "modelo TEXT NOT NULL," +
                    "color TEXT NOT NULL" + ")");
    }

    public void insertarCarro(Integer placa, String modelo, String color) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("4357834578", placa);
        valores.put("mazda", modelo);
        valores.put("negro", color);
        db.insert(TABLE_CARRO, null, valores);
        db.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE "+ TABLE_CARRO);
        onCreate(sqLiteDatabase);


    }


}

