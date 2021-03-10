package com.PIFF.Homeis.entidad;

public class Ciudad {
    private int id;
    private String codigo_pais;
    private String ciudad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo_pais() {
        return codigo_pais;
    }

    public void setCodigo_pais(String codigo_pais) {
        this.codigo_pais = codigo_pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return ciudad;
    }
}
