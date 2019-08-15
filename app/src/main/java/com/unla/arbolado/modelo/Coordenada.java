package com.unla.arbolado.modelo;

import android.content.ContentValues;

import com.unla.arbolado.SQLite.Contrato;

public class Coordenada {

    private int idCoordenada;
    private String latitud;
    private String longitud;

    public Coordenada() {

    }

    public Coordenada(String latitud, String longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Coordenada(int idCoordenada, String latitud, String longitud) {
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

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(Contrato.CoordenadaEntry.LATITUD, latitud);
        values.put(Contrato.CoordenadaEntry.LONGITUD, longitud);
        return values;
    }

}
