package com.iesvirgendelcarmen.dam.noticias.Modelo;

import java.io.Serializable;

public class Periodico implements Serializable {
    private String nombre;
    private String iconoPeriodico;
    private String idPeriodico;

    public Periodico(String nombre, String iconoPeriodico, String idPeriodico) {
        this.nombre = nombre;
        this.iconoPeriodico = iconoPeriodico;
        this.idPeriodico = idPeriodico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIconoPeriodico() {
        return iconoPeriodico;
    }

    public void setIconoPeriodico(String iconoPeriodico) {
        this.iconoPeriodico = iconoPeriodico;
    }

    public String getIdPeriodico() {
        return idPeriodico;
    }

    public void setIdPeriodico(String idPeriodico) {
        this.idPeriodico = idPeriodico;
    }
}
