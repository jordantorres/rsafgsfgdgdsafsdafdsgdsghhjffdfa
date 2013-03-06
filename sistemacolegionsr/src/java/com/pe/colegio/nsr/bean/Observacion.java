package com.pe.colegio.nsr.bean;

import java.io.Serializable;

public class Observacion implements Serializable {

    private int id;
    private int idUsuario;
    private int idBimestre;
    private String observacion;

    public Observacion() {
    }

    public Observacion(int id, int idUsuario, int idBimestre, String observacion) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idBimestre = idBimestre;
        this.observacion = observacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdBimestre() {
        return idBimestre;
    }

    public void setIdBimestre(int idBimestre) {
        this.idBimestre = idBimestre;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
