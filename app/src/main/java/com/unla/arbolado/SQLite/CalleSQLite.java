package com.unla.arbolado.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.unla.arbolado.modelo.Calle;

import java.util.ArrayList;
import java.util.List;

public class CalleSQLite extends AdminSQLite {

    private static CalleSQLite calleSQLite;

    private CalleSQLite(Context context) {
        super(context);
    }

    public static final CalleSQLite getInstance(Context context) {
        if (calleSQLite == null)
            calleSQLite = new CalleSQLite(context);

        return calleSQLite;
    }

    public long agregar(Calle calle) {
        SQLiteDatabase db = getWritableDatabase();
        return db.insert(Contrato.CalleEntry.TABLA, null, calle.toContentValues());
    }


    public List<Calle> traer() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(Contrato.CalleEntry.SELECT, null);
        List<Calle> calles = new ArrayList<>();

        while (cursor.moveToNext()) {
            calles.add(new Calle(Integer.parseInt(cursor.getString(0)), cursor.getString(1),
                    Integer.parseInt(cursor.getString(2)), Float.parseFloat(cursor.getString(3)), cursor.getString(4), cursor.getString(5)));
        }

        return calles;
    }
}
