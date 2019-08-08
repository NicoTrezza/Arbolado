package com.unla.arbolado.modelo;

import android.content.ContentValues;

import com.unla.arbolado.SQLite.Contrato;

public class Coordenada {

    private int idCoordenada;
    private double latitud;
    private double longitud;

    public Coordenada() {

    }

    public Coordenada(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Coordenada(int idCoordenada, double latitud, double longitud) {
        this.idCoordenada = idCoordenada;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public int getIdCoordenada() {
        return idCoordenada;
    }

    public void setIdCoordenada(int idCoordenada) {
        this.idCoordenada = idCoordenada;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(Contrato.CoordenadaEntry.LATITUD, latitud);
        values.put(Contrato.CoordenadaEntry.LONGITUD, longitud);
        return values;
    }

}
