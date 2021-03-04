package com.PIFF.Homeis.entidad;

import java.util.Date;

public class Publicacion {
    private String autor;
    private String titulo;
    private String descripcion;
    private Date fecha;

    public Publicacion(String autor, String titulo, String descripcion, Date fecha) {
        this.autor = autor;
        this.titulo = titulo;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
