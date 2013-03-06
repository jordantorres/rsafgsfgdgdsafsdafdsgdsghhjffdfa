package com.pe.colegio.nsr.bean;

import java.io.Serializable;

public class Grado implements Serializable {

    private int id;
    private String nombre;

    public Grado() {
    }

    public Grado(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
