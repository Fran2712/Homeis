package com.PIFF.Homeis.entidad;

import java.util.Date;

public class Servicio {

    private String autor;
    private String servicio;
    private String descrip;
    private String tipo;
    private Date fecha;

    public Servicio(String autor, String servicio, String descrip, String tipo, Date fecha) {
        this.autor = autor;
        this.servicio = servicio;
        this.descrip = descrip;
        this.tipo = tipo;
        this.fecha = fecha;
    }

    public Servicio() {
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
