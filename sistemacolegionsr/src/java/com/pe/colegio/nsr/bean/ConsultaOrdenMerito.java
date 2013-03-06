package com.pe.colegio.nsr.bean;

import java.io.Serializable;

public class ConsultaOrdenMerito implements Serializable {

    private String ordenMerito;
    private String bimestre1;
    private String bimestre2;
    private String bimestre3;
    private String bimestre4;

    public ConsultaOrdenMerito() {
    }

    public ConsultaOrdenMerito(String ordenMerito, String bimestre1, String bimestre2, String bimestre3, String bimestre4) {
        this.ordenMerito = ordenMerito;
        this.bimestre1 = bimestre1;
        this.bimestre2 = bimestre2;
        this.bimestre3 = bimestre3;
        this.bimestre4 = bimestre4;
    }

    public String getOrdenMerito() {
        return ordenMerito;
    }

    public void setOrdenMerito(String ordenMerito) {
        this.ordenMerito = ordenMerito;
    }

    public String getBimestre1() {
        return bimestre1;
    }

    public void setBimestre1(String bimestre1) {
        this.bimestre1 = bimestre1;
    }

    public String getBimestre2() {
        return bimestre2;
    }

    public void setBimestre2(String bimestre2) {
        this.bimestre2 = bimestre2;
    }

    public String getBimestre3() {
        return bimestre3;
    }

    public void setBimestre3(String bimestre3) {
        this.bimestre3 = bimestre3;
    }

    public String getBimestre4() {
        return bimestre4;
    }

    public void setBimestre4(String bimestre4) {
        this.bimestre4 = bimestre4;
    }
}
