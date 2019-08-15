package com.unla.arbolado.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.unla.arbolado.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioSQLite extends AdminSQLite {

    private static UsuarioSQLite usuarioSQLite;

    private UsuarioSQLite(Context context) {
        super(context);
    }

    public static final UsuarioSQLite getInstance(Context context) {
        if (usuarioSQLite == null)
            usuarioSQLite = new UsuarioSQLite(context);

        return usuarioSQLite;
    }

    public long agregar(Usuario usuario) {
        SQLiteDatabase db = getWritableDatabase();
        return db.insert(Contrato.UsuarioEntry.TABLA, null, usuario.toContentValues());
    }

    public int actualizar(Usuario usuario) {
        SQLiteDatabase db = getWritableDatabase();
        return db.update(Contrato.UsuarioEntry.TABLA, usuario.toContentValues(), Contrato.UsuarioEntry.ID + "=" + usuario.getIdUsuario(), null);
    }

    public int eliminar(int idUsuario) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(Contrato.UsuarioEntry.TABLA, Contrato.UsuarioEntry.ID + "=" + idUsuario, null);
    }

    public Usuario traer(int idUsuario) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(Contrato.UsuarioEntry.SELECT + " WHERE " + Contrato.UsuarioEntry.ID + "=" + idUsuario, null);
        Usuario usuario = null;

        if (cursor.moveToFirst()) {
            usuario = new Usuario(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), Integer.parseInt(cursor.getString(3)));
        }

        return usuario;
    }

    public List<Usuario> traer() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(Contrato.UsuarioEntry.SELECT, null);
        List<Usuario> usuarios = new ArrayList<Usuario>();

        while (cursor.moveToNext()) {
            usuarios.add(new Usuario(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), Integer.parseInt(cursor.getString(3))));
        }

        return usuarios;
    }

}
