package com.PIFF.Homeis.entidad;

public class Servicio {

    private String autor;
    private String servicio;
    private String descrip;

    public Servicio(String autor, String servicio, String descrip) {
        this.autor = autor;
        this.servicio = servicio;
        this.descrip = descrip;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
}
