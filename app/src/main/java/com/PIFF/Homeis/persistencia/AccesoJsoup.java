package com.PIFF.Homeis.persistencia;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.PIFF.Homeis.entidad.Pais;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AccesoJsoup implements Runnable {
    private List<Pais> paises;
    private Handler handler;
    private Document doc;

    public AccesoJsoup(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        paises = new ArrayList<Pais>();
        try {
            doc = Jsoup.connect("https://es.wikipedia.org/wiki/ISO_3166-1").get();
            Element elemento_padre = doc.getElementsByClass("mw-content-ltr").first();
            Element elemento_tabla = elemento_padre.getElementsByClass("wikitable sortable").first();
            Element elemento_cuerpo_tabla = elemento_tabla.getElementsByTag("tbody").first();
            Elements elemento_filas = elemento_cuerpo_tabla.getElementsByTag("tr");
            Log.d("datos","ha entrado por el metodo jsoup");
            for (Element elemento:elemento_filas) {
                Pais p = new Pais();
                Elements datos = elemento.getElementsByTag("td");
                for (int i=0; i<datos.size();i++){

                    if(i==1){
                        Element nombre = datos.get(1);
                        p.setNombre_pais(nombre.text());
                    }
                    if(i==2){
                        Element iso = datos.get(2);
                        p.setIso_pais(iso.text());
                    }
                }



                paises.add(p);
            }
            Message mensaje = new Message();
            Bundle datos = new Bundle();
            datos.putSerializable("ARRAYLIST",(Serializable)paises);
            mensaje.setData(datos);
            handler.sendMessage(mensaje);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
