package com.PIFF.Homeis.entidad;

import java.util.Date;

public class Request {
    private String request_author;
    private String request_title;
    private String request_subtext;
    private Date request_date;

    public Request(String request_author, String request_title, String request_subtext, Date request_date) {
        this.request_author = request_author;
        this.request_title = request_title;
        this.request_subtext = request_subtext;
        this.request_date = request_date;
    }

    public String getRequest_author() {
        return request_author;
    }

    public void setRequest_author(String request_author) {
        this.request_author = request_author;
    }

    public String getRequest_title() {
        return request_title;
    }

    public void setRequest_title(String request_title) {
        this.request_title = request_title;
    }

    public String getRequest_subtext() {
        return request_subtext;
    }

    public void setRequest_subtext(String request_subtext) {
        this.request_subtext = request_subtext;
    }

    public Date getRequest_date() {
        return request_date;
    }

    public void setRequest_date(Date request_date) {
        this.request_date = request_date;
    }
}
