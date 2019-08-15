package com.unla.arbolado.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.unla.arbolado.modelo.EstadoDelArbol;

import java.util.ArrayList;
import java.util.List;

public class EstadoDelArbolSQLite extends AdminSQLite {

    private static EstadoDelArbolSQLite estadoDelArbolSQLite;

    private EstadoDelArbolSQLite(Context context) {
        super(context);
    }

    public static final EstadoDelArbolSQLite getInstance(Context context) {
        if (estadoDelArbolSQLite == null)
            estadoDelArbolSQLite = new EstadoDelArbolSQLite(context);

        return estadoDelArbolSQLite;
    }

    public long agregar(EstadoDelArbol estadoDelArbol) {
        SQLiteDatabase db = getWritableDatabase();
        return db.insert(Contrato.EstadoDelArbolEntry.TABLA, null, estadoDelArbol.toContentValues());
    }

    public EstadoDelArbol traer(int idEstadoDelArbol) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(Contrato.EstadoDelArbolEntry.SELECT + " WHERE " + Contrato.EstadoDelArbolEntry.ID + "=" + idEstadoDelArbol, null);
        EstadoDelArbol estado = null;

        if (cursor.moveToFirst()) {
            estado = new EstadoDelArbol(Integer.parseInt(cursor.getString(0)), cursor.getString(1),
                    cursor.getString(2), cursor.getString(3), cursor.getString(4),
                    cursor.getString(5) ,cursor.getString(6), cursor.getString(7), cursor.getString(8));
        }

        return estado;
    }

    public List<EstadoDelArbol> traer() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(Contrato.EstadoDelArbolEntry.SELECT, null);
        List<EstadoDelArbol> estados = new ArrayList<>();

        while (cursor.moveToNext()) {
            estados.add(new EstadoDelArbol(Integer.parseInt(cursor.getString(0)), cursor.getString(1),
                    cursor.getString(2), cursor.getString(3), cursor.getString(4),
                    cursor.getString(5) ,cursor.getString(6), cursor.getString(7), cursor.getString(8)));
        }

        return estados;
    }

}
