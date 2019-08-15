package com.unla.arbolado.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.unla.arbolado.modelo.Arbol;

import java.util.ArrayList;
import java.util.List;

public class ArbolSQLite extends AdminSQLite {

    private static ArbolSQLite arbolSQLite;

    private ArbolSQLite(Context context) {
        super(context);
    }

    public static final ArbolSQLite getInstance(Context context) {
        if (arbolSQLite == null)
            arbolSQLite = new ArbolSQLite(context);

        return arbolSQLite;
    }

    public long agregar(Arbol arbol) {
        SQLiteDatabase db = getWritableDatabase();
        return db.insert(Contrato.ArbolEntry.TABLA, null, arbol.toContentValues());
    }

    public Arbol traer(int idArbol) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(Contrato.ArbolEntry.SELECT + " WHERE " + Contrato.ArbolEntry.ID + "=" + idArbol, null);
        Arbol arbol = null;

        if (cursor.moveToFirst()) {
            arbol = new Arbol(Integer.parseInt(cursor.getString(0)), cursor.getString(1),
                    Integer.parseInt(cursor.getString(2)), Float.parseFloat(cursor.getString(3)), Float.parseFloat(cursor.getString(4)),
                    Float.parseFloat(cursor.getString(5)), cursor.getString(6), cursor.getString(7));
        }

        return arbol;
    }

    public List<Arbol> traer() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(Contrato.ArbolEntry.SELECT, null);
        List<Arbol> arboles = new ArrayList<>();

        while (cursor.moveToNext()) {
            arboles.add(new Arbol(Integer.parseInt(cursor.getString(0)), cursor.getString(1),
                    Integer.parseInt(cursor.getString(2)), Float.parseFloat(cursor.getString(3)), Float.parseFloat(cursor.getString(4)),
                    Float.parseFloat(cursor.getString(5)), cursor.getString(6), cursor.getString(7)));
        }

        return arboles;
    }

}
