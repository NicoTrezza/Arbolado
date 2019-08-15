package com.unla.arbolado.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.unla.arbolado.modelo.Coordenada;

import java.util.ArrayList;
import java.util.List;

public class CoordenadaSQLite extends AdminSQLite {

    private static CoordenadaSQLite coordenadaSQLite;

    private CoordenadaSQLite(Context context) {
        super(context);
    }

    public static final CoordenadaSQLite getInstance(Context context) {
        if (coordenadaSQLite == null)
            coordenadaSQLite = new CoordenadaSQLite(context);

        return coordenadaSQLite;
    }

    public long agregar(Coordenada coordenada) {
        SQLiteDatabase db = getWritableDatabase();
        return db.insert(Contrato.CoordenadaEntry.TABLA, null, coordenada.toContentValues());
    }

    public Coordenada traer(int idCoordenada) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(Contrato.CoordenadaEntry.SELECT + " WHERE " + Contrato.CoordenadaEntry.ID + "=" + idCoordenada, null);
        Coordenada coordenada = null;

        if (cursor.moveToFirst()) {
            coordenada = new Coordenada(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));
        }

        return coordenada;
    }

    public List<Coordenada> traer() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(Contrato.CoordenadaEntry.SELECT, null);
        List<Coordenada> coordenadas = new ArrayList<>();

        while (cursor.moveToNext()) {
            coordenadas.add(new Coordenada(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2)));
        }

        return coordenadas;
    }

}
