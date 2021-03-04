package com.PIFF.Homeis.entidad;

public class Direccion {
    private String direccion_1;
    private String direccion_2;
    private String codigo_postal;
    private String pais;
    private String ciudad;

    public Direccion() {
    }

    public Direccion(String direccion_1, String direccion_2, String codigo_postal, String pais, String ciudad) {
        this.direccion_1 = direccion_1;
        this.direccion_2 = direccion_2;
        this.codigo_postal = codigo_postal;
        this.pais = pais;
        this.ciudad = ciudad;
    }

    public String getDireccion_1() {
        return direccion_1;
    }

    public void setDireccion_1(String direccion_1) {
        this.direccion_1 = direccion_1;
    }

    public String getDireccion_2() {
        return direccion_2;
    }

    public void setDireccion_2(String direccion_2) {
        this.direccion_2 = direccion_2;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
