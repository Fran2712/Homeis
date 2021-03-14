package com.PIFF.Homeis.entidad;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String username;
    private String email;
    private String password;
    private Direccion direccion;


    public Usuario() {
    }
    public Usuario(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Usuario(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username =username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
