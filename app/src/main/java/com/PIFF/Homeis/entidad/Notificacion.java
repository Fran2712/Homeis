package com.PIFF.Homeis.entidad;

import java.util.Date;

public class Notificacion {
    private String nombre_user;
    private String sub_text;
    private Date date;
    private String notification_type;

    public Notificacion(String nombre_user, String sub_text, Date date, String notification_type) {
        this.nombre_user = nombre_user;
        this.sub_text = sub_text;
        this.date = date;
        this.notification_type = notification_type;
    }

    public String getNombre_user() {
        return nombre_user;
    }

    public void setNombre_user(String nombre_user) {
        this.nombre_user = nombre_user;
    }

    public String getSub_text() {
        return sub_text;
    }

    public void setSub_text(String sub_text) {
        this.sub_text = sub_text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNotification_type() {
        return notification_type;
    }

    public void setNotification_type(String notification_type) {
        this.notification_type = notification_type;
    }
}
