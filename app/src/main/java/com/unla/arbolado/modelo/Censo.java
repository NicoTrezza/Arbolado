package com.unla.arbolado.modelo;

import android.content.ContentValues;

import com.unla.arbolado.SQLite.Contrato;

import java.io.Serializable;

public class Censo implements Serializable {

    private int idCenso;
    private Usuario usuario;
    private Calle calle;
    private Arbol arbol;
    private EstadoDelArbol estadoDelArbol;
    private Coordenada coordenada;

    public Censo() {

    }

    public Censo(Usuario usuario, Calle calle, Arbol arbol, EstadoDelArbol estadoDelArbol, Coordenada coordenada) {
        this.usuario = usuario;
        this.calle = calle;
        this.arbol = arbol;
        this.estadoDelArbol = estadoDelArbol;
        this.coordenada = coordenada;
    }

    public Censo(int idCenso, Usuario usuario, Calle calle, Arbol arbol, EstadoDelArbol estadoDelArbol, Coordenada coordenada) {
        this.idCenso = idCenso;
        this.usuario = usuario;
        this.calle = calle;
        this.arbol = arbol;
        this.estadoDelArbol = estadoDelArbol;
        this.coordenada = coordenada;
    }

    public int getIdCenso() {
        return idCenso;
    }

    public void setIdCenso(int idCenso) {
        this.idCenso = idCenso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Calle getCalle() {
        return calle;
    }

    public void setCalle(Calle calle) {
        this.calle = calle;
    }

    public Arbol getArbol() {
        return arbol;
    }

    public void setArbol(Arbol arbol) {
        this.arbol = arbol;
    }

    public EstadoDelArbol getEstadoDelArbol() {
        return estadoDelArbol;
    }

    public void setEstadoDelArbol(EstadoDelArbol estadoDelArbol) {
        this.estadoDelArbol = estadoDelArbol;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(Contrato.CensoEntry.USUARIO, usuario.getIdUsuario());
        values.put(Contrato.CensoEntry.CALLE, calle.getIdCalle());
        values.put(Contrato.CensoEntry.ARBOL, arbol.getIdArbol());
        values.put(Contrato.CensoEntry.ESTADO_DEL_ARBOL, estadoDelArbol.getIdEstadoDelArbol());
        values.put(Contrato.CensoEntry.COORDENADA, coordenada.getIdCoordenada());
        return values;
    }
}
