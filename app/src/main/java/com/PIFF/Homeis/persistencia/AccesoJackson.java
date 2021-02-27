package com.PIFF.Homeis.persistencia;

import android.content.res.AssetManager;

import com.PIFF.Homeis.entidad.Ciudad;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class AccesoJackson {
    public static List<Ciudad> obtenerJsonCiudades(AssetManager am, String iso_pais){
        ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
        try {

            InputStream is=am.open("ciudades.json");
            ObjectMapper mapper = new ObjectMapper();
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json_string = new String(buffer,"UTF-8");
            JsonFactory jsonFactory = new JsonFactory();
            JsonParser jsonParser = jsonFactory.createJsonParser(json_string);
            jsonParser.nextToken();
            while (jsonParser.nextToken() == JsonToken.START_OBJECT) {
                Ciudad ciudad = mapper.readValue(jsonParser, Ciudad.class);
                if(ciudad.getCodigo_pais().equals(iso_pais)){
                    ciudades.add(ciudad);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return ciudades;
    }
}
