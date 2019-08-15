package com.unla.arbolado.SQLite;

import android.provider.BaseColumns;

public class Contrato {

    public static abstract class UsuarioEntry implements BaseColumns {
        public static final String TABLA = "usuario";
        public static final String ID = "idUsuario";
        public static final String NOMBRE = "nombre";
        public static final String APELLIDO = "apellido";
        public static final String DNI = "dni";
        public static final String CREATE = "CREATE TABLE " + TABLA +
                "( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NOMBRE + " TEXT, "
                + APELLIDO + " TEXT, "
                + DNI + " INTEGER ) ";
        public static final String DROP = "DROP TABLE IF EXISTS " + TABLA;
        public static final String SELECT = "SELECT " + ID + ", "
                + NOMBRE + ", "
                + APELLIDO + ", "
                + DNI + " FROM "
                + TABLA;
    }

    public static abstract class CalleEntry implements BaseColumns {
        public static final String TABLA = "calle";
        public static final String ID = "idCalle";
        public static final String NOMBRE = "nombre";
        public static final String NUMERO_FRENTE = "numeroFrente";
        public static final String ANCHO_VEREDA = "anchoVereda";
        public static final String PARIDAD = "paridad";
        public static final String TRANSITO = "transito";
        public static final String CREATE = "CREATE TABLE " + TABLA +
                "( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NOMBRE + " TEXT, "
                + NUMERO_FRENTE + " INTEGER, "
                + ANCHO_VEREDA + " REAL, "
                + PARIDAD + " TEXT, "
                + TRANSITO + " TEXT ) ";
        public static final String DROP = "DROP TABLE IF EXISTS " + TABLA;
        public static final String SELECT = "SELECT " + ID + ", "
                + NOMBRE + ", "
                + NUMERO_FRENTE + ", "
                + ANCHO_VEREDA + ", "
                + PARIDAD + ", "
                + TRANSITO + " FROM "
                + TABLA;
    }

    public static abstract class ArbolEntry implements BaseColumns {
        public static final String TABLA = "arbol";
        public static final String ID = "idArbol";
        public static final String ESPECIE = "especie";
        public static final String NUMERO_ARBOL = "numeroArbol";
        public static final String DISTANCIA_PLANTAS = "distanciaEntrePlantas";
        public static final String DISTANCIA_MURO = "distanciaAlMuro";
        public static final String CIRCUNFERENCIA_ARBOL = "circunferenciaDelArbol";
        public static final String CAZUELA = "cazuela";
        public static final String COMENTARIO = "comentario";
        public static final String CREATE = "CREATE TABLE " + TABLA +
                "( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ESPECIE + " TEXT, "
                + NUMERO_ARBOL + " INTEGER, "
                + DISTANCIA_PLANTAS + " REAL, "
                + DISTANCIA_MURO + " REAL, "
                + CIRCUNFERENCIA_ARBOL + " REAL, "
                + CAZUELA + " TEXT, "
                + COMENTARIO + " TEXT ) ";
        public static final String DROP = "DROP TABLE IF EXISTS " + TABLA;
        public static final String SELECT = "SELECT " + ID + ", "
                + ESPECIE + ", "
                + NUMERO_ARBOL + ", "
                + DISTANCIA_PLANTAS + ", "
                + DISTANCIA_MURO + ", "
                + CIRCUNFERENCIA_ARBOL + ", "
                + CAZUELA + ", "
                + COMENTARIO + " FROM "
                + TABLA;
    }

    public static abstract class EstadoDelArbolEntry implements BaseColumns {
        public static final String TABLA = "estadoDelArbol";
        public static final String ID = "idEstadoDelArbol";
        public static final String ESTADO_SANITARIO = "estadoSanitario";
        public static final String INCLINACION = "inclinacion";
        public static final String AHUECAMIENTO = "ahuecamiento";
        public static final String CABLES = "cables";
        public static final String LUMINARIA = "luminaria";
        public static final String DAÑOS = "daños";
        public static final String VEREDAS = "veredas";
        public static final String PODAS = "podas";
        public static final String CREATE = "CREATE TABLE " + TABLA +
                "( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ESTADO_SANITARIO + " TEXT, "
                + INCLINACION + " TEXT, "
                + AHUECAMIENTO + " TEXT, "
                + CABLES + " TEXT, "
                + LUMINARIA + " TEXT, "
                + DAÑOS + " TEXT, "
                + VEREDAS + " TEXT, "
                + PODAS + " TEXT ) ";
        public static final String DROP = "DROP TABLE IF EXISTS " + TABLA;
        public static final String SELECT = "SELECT " + ID + ", "
                + ESTADO_SANITARIO + ", "
                + INCLINACION + ", "
                + AHUECAMIENTO + ", "
                + CABLES + ", "
                + LUMINARIA + ", "
                + DAÑOS + ", "
                + VEREDAS + ", "
                + PODAS + " FROM "
                + TABLA;
    }

    public static abstract class CoordenadaEntry implements BaseColumns {
        public static final String TABLA = "coordenada";
        public static final String ID = "idCoordenada";
        public static final String LATITUD = "latitud";
        public static final String LONGITUD = "longitud";
        public static final String CREATE = "CREATE TABLE " + TABLA +
                "( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + LATITUD + " TEXT, "
                + LONGITUD + " TEXT ) ";
        public static final String DROP = "DROP TABLE IF EXISTS " + TABLA;
        public static final String SELECT = "SELECT " + ID + ", "
                + LATITUD + ", "
                + LONGITUD + " FROM "
                + TABLA;
    }

    public static abstract class CensoEntry implements BaseColumns {
        public static final String TABLA = "censo";
        public static final String ID = "idCenso";
        public static final String USUARIO = "usuario";
        public static final String CALLE = "calle";
        public static final String ARBOL = "arbol";
        public static final String ESTADO_DEL_ARBOL = "estadoDelArbol";
        public static final String COORDENADA = "coordenada";
        public static final String CREATE = "CREATE TABLE " + TABLA +
                "( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + USUARIO + " INTEGER, "
                + CALLE + " INTEGER, "
                + ARBOL + " INTEGER, "
                + ESTADO_DEL_ARBOL + " INTEGER, "
                + COORDENADA + " INTEGER ) ";
        public static final String DROP = "DROP TABLE IF EXISTS " + TABLA;
        public static final String SELECT = "SELECT " + ID + ", "
                + USUARIO + ", "
                + CALLE + ", "
                + ARBOL + ", "
                + ESTADO_DEL_ARBOL + ", "
                + COORDENADA + " FROM "
                + TABLA;
    }

}
