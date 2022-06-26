package com.example.pm1e1_35969.Acciones;

public class Registro {
    /*Nombre de la Base de datos */
    public static final String NameDataBase = "DBE1_3";
    /* Creacion de tablas de la BB */
    public static final String tablaUsuarios = "empleados";

    /* Campos de la Tabla Empleados */
    public static final String id = "id";
    public static final String nombres = "nombres";
    public static final String apellidos = "apellidos";
    public static final String edad = "edad";
    public static final String correo = "correo";
    public static final String direccion = "direccion";

    /* Sentencias SQL para crear tabla */
    public static final String CreateTableUsuarios = "CREATE TABLE usuarios " +
            "( id INTEGER PRIMARY KEY AUTOINCREMENT,"+
            " nombres TEXT, apellidos TEXT, edad INTEGER, "+
            " correo TEXT, direccion TEXT)";

    public static final String DropTableUsuarios = "DROP TABLE IF EXISTS usuarios";
}
