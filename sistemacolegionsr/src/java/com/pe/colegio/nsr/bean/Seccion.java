package com.pe.colegio.nsr.bean;

import java.io.Serializable;

public class Seccion implements Serializable {

    private int id;
    private String nombre;
    private int idGrado;
    private int vacantes;

    public Seccion() {
    }

    public Seccion(int id, String nombre, int idGrado, int vacantes) {
        this.id = id;
        this.nombre = nombre;
        this.idGrado = idGrado;
        this.vacantes = vacantes;
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

    public int getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(int idGrado) {
        this.idGrado = idGrado;
    }

    public int getVacantes() {
        return vacantes;
    }

    public void setVacantes(int vacantes) {
        this.vacantes = vacantes;
    }
}
