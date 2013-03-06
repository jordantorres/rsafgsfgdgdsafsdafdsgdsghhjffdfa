package com.pe.colegio.nsr.bean;

import java.io.Serializable;

/**
 *
 * @author DIEGO PISCO
 */
public class Configuracion implements Serializable {

    private String objeto;
    private String valor;
    private String observacion;

    public Configuracion() {
    }

    public Configuracion(String objeto, String valor, String observacion) {
        this.objeto = objeto;
        this.valor = valor;
        this.observacion = observacion;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
