package com.PIFF.Homeis.entidad;

import java.util.Date;

public class Pregunta {

    private String pregunta;
    private String autor;
    private String tipo;
    private Date fecha;

    public Pregunta(String autor, String pregunta, String tipo, Date fecha) {
        this.pregunta = pregunta;
        this.autor = autor;
        this.tipo = tipo;
        this.fecha = fecha;
    }

    public Pregunta() {
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
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
