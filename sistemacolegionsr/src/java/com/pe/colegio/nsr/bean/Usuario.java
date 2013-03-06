package com.pe.colegio.nsr.bean;

import java.io.Serializable;

public class Usuario implements Serializable {

    private int id;
    private int idTipo;
    private String nombre;
    private String apellido;
    private String apoderado;
    private String usuario;
    private String contrasenia;
    private String foto;
    private String estadoDeuda;

    public Usuario() {
    }

    public Usuario(int id, int idTipo, String nombre, String apellido, String apoderado, String usuario, String contrasenia, String foto, String estadoDeuda) {
        this.id = id;
        this.idTipo = idTipo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.apoderado = apoderado;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.foto = foto;
        this.estadoDeuda = estadoDeuda;
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
}
