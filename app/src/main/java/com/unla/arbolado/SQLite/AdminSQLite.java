package com.unla.arbolado.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLite extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "arbolado.db";

    public AdminSQLite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Contrato.UsuarioEntry.CREATE);
        db.execSQL(Contrato.CalleEntry.CREATE);
        db.execSQL(Contrato.ArbolEntry.CREATE);
        db.execSQL(Contrato.EstadoDelArbolEntry.CREATE);
        db.execSQL(Contrato.CoordenadaEntry.CREATE);
        db.execSQL(Contrato.CensoEntry.CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(Contrato.UsuarioEntry.DROP);
        db.execSQL(Contrato.CalleEntry.DROP);
        db.execSQL(Contrato.ArbolEntry.DROP);
        db.execSQL(Contrato.EstadoDelArbolEntry.DROP);
        db.execSQL(Contrato.CoordenadaEntry.DROP);
        db.execSQL(Contrato.CensoEntry.DROP);
        onCreate(db);
    }

}
