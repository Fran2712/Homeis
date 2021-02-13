package com.PIFF.Homeis;

public class Publicacion {
    private String autor;
    private String titulo;
    private String descripcion;

    public Publicacion(String autor, String titulo, String descripcion) {
        this.autor = autor;
        this.titulo = titulo;
        this.descripcion = descripcion;
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
}
