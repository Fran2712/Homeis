package com.PIFF.Homeis.entidad;

public class Pais {
    private String nombre_pais;
    private String iso_pais;

    public String getNombre_pais() {
        return nombre_pais;
    }

    public void setNombre_pais(String nombre_pais) {
        this.nombre_pais = nombre_pais;
    }

    public String getIso_pais() {
        return iso_pais;
    }

    public void setIso_pais(String iso_pais) {
        this.iso_pais = iso_pais;
    }

    @Override
    public String toString() {
        return nombre_pais;
    }
}
