package com.unla.arbolado.modelo;

import android.content.ContentValues;

import com.unla.arbolado.SQLite.Contrato;

import java.io.Serializable;

public class Usuario implements Serializable {

    private int idUsuario;
    private String nombre;
    private String apellido;
    private int dni;

    public Usuario() {

    }

    public Usuario(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public Usuario(int idUsuario, String nombre, String apellido, int dni) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(Contrato.UsuarioEntry.NOMBRE, nombre);
        values.put(Contrato.UsuarioEntry.APELLIDO, apellido);
        values.put(Contrato.UsuarioEntry.DNI, dni);
        return values;
    }

}
