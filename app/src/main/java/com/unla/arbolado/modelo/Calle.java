package com.unla.arbolado.modelo;

import android.content.ContentValues;

import com.unla.arbolado.SQLite.Contrato;

public class Calle {

    private int idCalle;
    private String nombre;
    private int numeroFrente;
    private float anchoVereda;
    private String paridad;
    private String transito;

    public Calle() {

    }

    public Calle(String nombre, int numeroFrente, float anchoVereda, String paridad, String transito) {
        this.nombre = nombre;
        this.numeroFrente = numeroFrente;
        this.anchoVereda = anchoVereda;
        this.paridad = paridad;
        this.transito = transito;
    }

    public Calle(int idCalle, String nombre, int numeroFrente, float anchoVereda, String paridad, String transito) {
        this.idCalle = idCalle;
        this.nombre = nombre;
        this.numeroFrente = numeroFrente;
        this.anchoVereda = anchoVereda;
        this.paridad = paridad;
        this.transito = transito;
    }

    public int getIdCalle() {
        return idCalle;
    }

    public void setIdCalle(int idCalle) {
        this.idCalle = idCalle;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroFrente() {
        return numeroFrente;
    }

    public void setNumeroFrente(int numeroFrente) {
        this.numeroFrente = numeroFrente;
    }

    public float getAnchoVereda() {
        return anchoVereda;
    }

    public void setAnchoVereda(float anchoVereda) {
        this.anchoVereda = anchoVereda;
    }

    public String getParidad() {
        return paridad;
    }

    public void setParidad(String paridad) {
        this.paridad = paridad;
    }

    public String getTransito() {
        return transito;
    }

    public void setTransito(String transito) {
        this.transito = transito;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(Contrato.CalleEntry.NOMBRE, nombre);
        values.put(Contrato.CalleEntry.NUMERO_FRENTE, numeroFrente);
        values.put(Contrato.CalleEntry.ANCHO_VEREDA, anchoVereda);
        values.put(Contrato.CalleEntry.PARIDAD, paridad);
        values.put(Contrato.CalleEntry.TRANSITO, transito);
        return values;
    }
}
