package com.pe.colegio.nsr.bean;

import java.io.Serializable;

public class Alumno implements Serializable {

    private int id;
    private int idTipo;
    private String nombre;
    private String apellido;
    private String apoderado;
    private String usuario;
    private String contrasenia;
    private String foto;
    private String estadoDeuda;
    private int idSeccion;
    private int idGrado;

    public Alumno() {
    }

    public Alumno(int id, int idTipo, String nombre, String apellido, String apoderado, String usuario, String contrasenia, String foto, String estadoDeuda, int idSeccion, int idGrado) {
        this.id = id;
        this.idTipo = idTipo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.apoderado = apoderado;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.foto = foto;
        this.estadoDeuda = estadoDeuda;
        this.idSeccion = idSeccion;
        this.idGrado = idGrado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
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

    public String getApoderado() {
        return apoderado;
    }

    public void setApoderado(String apoderado) {
        this.apoderado = apoderado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getEstadoDeuda() {
        return estadoDeuda;
    }

    public void setEstadoDeuda(String estadoDeuda) {
        this.estadoDeuda = estadoDeuda;
    }

    public int getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }

    public int getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(int idGrado) {
        this.idGrado = idGrado;
    }
}
