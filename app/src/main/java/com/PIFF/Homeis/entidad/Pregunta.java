package com.PIFF.Homeis.entidad;

public class
Pregunta {

    private String pregunta;
    private String autor;

    public Pregunta(String autor, String pregunta) {
        this.pregunta = pregunta;
        this.autor = autor;
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
}
