package com.unla.arbolado.modelo;

import android.content.ContentValues;

import com.unla.arbolado.SQLite.Contrato;

public class Arbol {

    private int idArbol;
    private String especie;
    private int numeroArbol;
    private float distanciaEntrePlantas;
    private float distanciaAlMuro;
    private float circunferenciaDelArbol;
    private String cazuela;
    private String comentario;

    public Arbol() {

    }

    public Arbol(String especie, int numeroArbol, float distanciaEntrePlantas, float distanciaAlMuro, float circunferenciaDelArbol, String cazuela, String comentario) {
        this.especie = especie;
        this.numeroArbol = numeroArbol;
        this.distanciaEntrePlantas = distanciaEntrePlantas;
        this.distanciaAlMuro = distanciaAlMuro;
        this.circunferenciaDelArbol = circunferenciaDelArbol;
        this.cazuela = cazuela;
        this.comentario = comentario;
    }

    public Arbol(int idArbol, String especie, int numeroArbol, float distanciaEntrePlantas, float distanciaAlMuro, float circunferenciaDelArbol, String cazuela, String comentario) {
        this.idArbol = idArbol;
        this.especie = especie;
        this.numeroArbol = numeroArbol;
        this.distanciaEntrePlantas = distanciaEntrePlantas;
        this.distanciaAlMuro = distanciaAlMuro;
        this.circunferenciaDelArbol = circunferenciaDelArbol;
        this.cazuela = cazuela;
        this.comentario = comentario;
    }

    public int getIdArbol() {
        return idArbol;
    }

    public void setIdArbol(int idArbol) {
        this.idArbol = idArbol;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getNumeroArbol() {
        return numeroArbol;
    }

    public void setNumeroArbol(int numeroArbol) {
        this.numeroArbol = numeroArbol;
    }

    public float getDistanciaEntrePlantas() {
        return distanciaEntrePlantas;
    }

    public void setDistanciaEntrePlantas(float distanciaEntrePlantas) {
        this.distanciaEntrePlantas = distanciaEntrePlantas;
    }

    public float getDistanciaAlMuro() {
        return distanciaAlMuro;
    }

    public void setDistanciaAlMuro(float distanciaAlMuro) {
        this.distanciaAlMuro = distanciaAlMuro;
    }

    public float getCircunferenciaDelArbol() {
        return circunferenciaDelArbol;
    }

    public void setCircunferenciaDelArbol(float circunferenciaDelArbol) {
        this.circunferenciaDelArbol = circunferenciaDelArbol;
    }

    public String getCazuela() {
        return cazuela;
    }

    public void setCazuela(String cazuela) {
        this.cazuela = cazuela;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(Contrato.ArbolEntry.ESPECIE, especie);
        values.put(Contrato.ArbolEntry.NUMERO_ARBOL, numeroArbol);
        values.put(Contrato.ArbolEntry.DISTANCIA_PLANTAS, distanciaEntrePlantas);
        values.put(Contrato.ArbolEntry.DISTANCIA_MURO, distanciaAlMuro);
        values.put(Contrato.ArbolEntry.CIRCUNFERENCIA_ARBOL, circunferenciaDelArbol);
        values.put(Contrato.ArbolEntry.CAZUELA, cazuela);
        values.put(Contrato.ArbolEntry.COMENTARIO, comentario);
        return values;
    }

}
