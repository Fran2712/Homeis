package com.PIFF.Homeis.entidad;

import java.util.Date;

public class PublicacionSocial {
    private String autor,titulo,descrip,tipo;
    private Date fecha;

    public PublicacionSocial(String autor, String titulo, String descrip, String tipo, Date fecha) {
        this.autor = autor;
        this.titulo = titulo;
        this.descrip = descrip;
        this.fecha = fecha;
        this.tipo = tipo;
    }

    public PublicacionSocial() {
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
