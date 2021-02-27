package com.PIFF.Homeis;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.PIFF.Homeis.entidad.Ciudad;
import com.PIFF.Homeis.entidad.Pais;
import com.PIFF.Homeis.persistencia.AccesoJackson;
import com.PIFF.Homeis.persistencia.AccesoJsoup;

import java.util.List;

public class Direccion extends AppCompatActivity {
    private Button btn_regster;
    private Spinner spn_paises;
    private Spinner spn_ciudades;
    private Handler manejador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direccion);
        btn_regster = findViewById(R.id.BTN_regster);
        spn_paises = findViewById(R.id.SPN_paises);
        spn_ciudades = findViewById(R.id.SPN_ciudades);

        // Adaptador opcional hasta que carga el adaptador de los paises para que no muestre el spinner vacio
        String[] selecciona = {"Selecciona un pais..."};
        ArrayAdapter<String> adaptadorOpcional = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,selecciona);
        spn_paises.setAdapter(adaptadorOpcional);
        //----------------------------------------------------------------------------------------------------

        // Manejador que recupera los datos mediante WebScrapping y devuelve una lista de objetos Pais que es inflada al spinner
        manejador = new Handler(getMainLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                Bundle datos = msg.getData();
                List<Pais> lista_paises= (List<Pais>) datos.getSerializable("ARRAYLIST");
                Pais pais_placeHolder = new Pais();
                pais_placeHolder.setNombre_pais("Selecciona un pais...");
                pais_placeHolder.setIso_pais("Selecciona un pais...");
                // Eliminamos la primera posicion null
                lista_paises.remove(0);
                lista_paises.add(0,pais_placeHolder);

                ArrayAdapter<Pais> adapter = new ArrayAdapter<Pais>(Direccion.this,R.layout.support_simple_spinner_dropdown_item,lista_paises){
                    @Override
                    public boolean isEnabled(int position) {
                        if(position==0){
                            //Deshabilitamos el primer elemento que se usara para el hint
                            return false;
                        }else{
                            return true;
                        }
                    }

                    @Override
                    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        View view = super.getDropDownView(position, convertView, parent);
                        TextView tv = (TextView) view;
                        if(position == 0){
                            // Set the hint text color gray
                            tv.setTextColor(Color.GRAY);
                        }
                        else {
                            tv.setTextColor(Color.BLACK);
                        }
                        return view;
                    }
                };
                adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                spn_paises.setAdapter(adapter);
            }
        };

        // Ejecutamos el hilo del Jsoup
        AccesoJsoup accesoJsoup = new AccesoJsoup(manejador);
        Thread hilo = new Thread(accesoJsoup);
        hilo.start();

        // Adaptador opcional hasta que carga el adaptador de los paises
        String[] seleccionaCiudad = {"Selecciona una ciudad..."};
        ArrayAdapter<String> adaptadorOpcionalCiudad = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,seleccionaCiudad);
        spn_ciudades.setAdapter(adaptadorOpcionalCiudad);
        // ---------------------------------------------------------------
        spn_paises.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position!=0){
                    Pais pSeleccionado = (Pais) spn_paises.getItemAtPosition(position);
                    AssetManager am = getAssets();
                    List<Ciudad> ciudades = AccesoJackson.obtenerJsonCiudades(am,pSeleccionado.getIso_pais());
                    ArrayAdapter<Ciudad> adapter = new ArrayAdapter<Ciudad>(Direccion.this,R.layout.support_simple_spinner_dropdown_item,ciudades){
                        @Override
                        public boolean isEnabled(int position) {
                            if(position==0){
                                //Deshabilitamos el primer elemento que se usara para el hint
                                return false;
                            }else{
                                return true;
                            }
                        }

                        @Override
                        public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                            View view = super.getDropDownView(position, convertView, parent);
                            TextView tv = (TextView) view;
                            if(position == 0){
                                // Set the hint text color gray
                                tv.setTextColor(Color.GRAY);
                            }
                            else {
                                tv.setTextColor(Color.BLACK);
                            }
                            return view;
                        }
                    };
                    adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                    spn_ciudades.setAdapter(adapter);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_regster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Direccion.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
}