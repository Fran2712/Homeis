package com.PIFF.Homeis.entidad;

import java.util.Date;

public class PublicacionSocial {
    private String autor,titulo,descrip;
    private Date fecha;

    public PublicacionSocial(String autor, String titulo, String descrip, Date fecha) {
        this.autor = autor;
        this.titulo = titulo;
        this.descrip = descrip;
        this.fecha = fecha;
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
}
