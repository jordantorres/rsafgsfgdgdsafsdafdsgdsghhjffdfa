package com.pe.colegio.nsr.bean;

import java.io.Serializable;

public class Libreta implements Serializable {

    private int idCurso;
    private String curso;
    private String notaBimestre1;
    private String notaBimestre2;
    private String notaBimestre3;
    private String notaBimestre4;

    public Libreta() {
    }

    public Libreta(int idCurso, String curso, String notaBimestre1, String notaBimestre2, String notaBimestre3, String notaBimestre4) {
        this.idCurso = idCurso;
        this.curso = curso;
        this.notaBimestre1 = notaBimestre1;
        this.notaBimestre2 = notaBimestre2;
        this.notaBimestre3 = notaBimestre3;
        this.notaBimestre4 = notaBimestre4;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNotaBimestre1() {
        return notaBimestre1;
    }

    public void setNotaBimestre1(String notaBimestre1) {
        this.notaBimestre1 = notaBimestre1;
    }

    public String getNotaBimestre2() {
        return notaBimestre2;
    }

    public void setNotaBimestre2(String notaBimestre2) {
        this.notaBimestre2 = notaBimestre2;
    }

    public String getNotaBimestre3() {
        return notaBimestre3;
    }

    public void setNotaBimestre3(String notaBimestre3) {
        this.notaBimestre3 = notaBimestre3;
    }

    public String getNotaBimestre4() {
        return notaBimestre4;
    }

    public void setNotaBimestre4(String notaBimestre4) {
        this.notaBimestre4 = notaBimestre4;
    }
}
