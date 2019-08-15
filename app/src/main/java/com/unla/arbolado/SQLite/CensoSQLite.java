package com.unla.arbolado.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.unla.arbolado.modelo.Censo;

import java.util.ArrayList;
import java.util.List;

public class CensoSQLite extends AdminSQLite {

    private static CensoSQLite censoSQLite;

    private CensoSQLite(Context context) {
        super(context);
    }

    public static final CensoSQLite getInstance(Context context) {
        if (censoSQLite == null)
            censoSQLite = new CensoSQLite(context);

        return censoSQLite;
    }

    public long agregar(Censo censo) {
        SQLiteDatabase db = getWritableDatabase();
        return db.insert(Contrato.CensoEntry.TABLA, null, censo.toContentValues());
    }

    public int actualizar(Censo censo) {
        SQLiteDatabase db = getWritableDatabase();
        return db.update(Contrato.CensoEntry.TABLA, censo.toContentValues(), Contrato.CensoEntry.ID + "=" + censo.getIdCenso(), null);
    }

    public int eliminar(int idCenso) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(Contrato.CensoEntry.TABLA, Contrato.CensoEntry.ID + "=" + idCenso, null);
    }

    public Censo traer(Context context, int idCenso) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(Contrato.CensoEntry.SELECT + " WHERE " + Contrato.CensoEntry.ID + "=" + idCenso, null);
        Censo censo = null;

        if (cursor.moveToFirst()) {
            censo = new Censo(Integer.parseInt(cursor.getString(0)), UsuarioSQLite.getInstance(context).traer(Integer.parseInt(cursor.getString(1))),
                    CalleSQLite.getInstance(context).traer(Integer.parseInt(cursor.getString(2))),
                    ArbolSQLite.getInstance(context).traer(Integer.parseInt(cursor.getString(3))),
                    EstadoDelArbolSQLite.getInstance(context).traer(Integer.parseInt(cursor.getString(4))),
                    CoordenadaSQLite.getInstance(context).traer(Integer.parseInt(cursor.getString(5))));
        }

        return censo;
    }

    public List<Censo> traer(Context context) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(Contrato.CensoEntry.SELECT, null);
        List<Censo> censos = new ArrayList<Censo>();

        while (cursor.moveToNext()) {
            censos.add(new Censo(Integer.parseInt(cursor.getString(0)), UsuarioSQLite.getInstance(context).traer(Integer.parseInt(cursor.getString(1))),
                    CalleSQLite.getInstance(context).traer(Integer.parseInt(cursor.getString(2))),
                    ArbolSQLite.getInstance(context).traer(Integer.parseInt(cursor.getString(3))),
                    EstadoDelArbolSQLite.getInstance(context).traer(Integer.parseInt(cursor.getString(4))),
                    CoordenadaSQLite.getInstance(context).traer(Integer.parseInt(cursor.getString(5)))));
        }

        return censos;
    }
}
