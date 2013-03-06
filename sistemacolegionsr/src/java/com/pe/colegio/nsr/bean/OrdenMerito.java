package com.pe.colegio.nsr.bean;

import java.io.Serializable;

public class OrdenMerito implements Serializable {

    private int id;
    private int idUsuario;
    private int idBimestre;
    private String conducta;
    private String inasistencias;
    private String tardanzas;

    public OrdenMerito() {
    }

    public OrdenMerito(int id, int idUsuario, int idBimestre, String conducta, String inasistencias, String tardanzas) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idBimestre = idBimestre;
        this.conducta = conducta;
        this.inasistencias = inasistencias;
        this.tardanzas = tardanzas;
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

    public String getConducta() {
        return conducta;
    }

    public void setConducta(String conducta) {
        this.conducta = conducta;
    }

    public String getInasistencias() {
        return inasistencias;
    }

    public void setInasistencias(String inasistencias) {
        this.inasistencias = inasistencias;
    }

    public String getTardanzas() {
        return tardanzas;
    }

    public void setTardanzas(String tardanzas) {
        this.tardanzas = tardanzas;
    }
}
