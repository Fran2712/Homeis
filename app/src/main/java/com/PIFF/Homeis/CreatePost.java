package com.PIFF.Homeis;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.PIFF.Homeis.entidad.Pregunta;
import com.PIFF.Homeis.entidad.PublicacionSocial;
import com.PIFF.Homeis.entidad.Servicio;
import com.PIFF.Homeis.entidad.UserDetails;
import com.PIFF.Homeis.persistencia.AccesoFirebase;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Date;

public class CreatePost extends AppCompatActivity {
    private Button btn_create;
    private Spinner spn_service_type;
    private TextInputLayout servicio_a_ofrecer, desccripcion;
    private int sel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_request);
        btn_create = findViewById(R.id.btn_create_post);
        spn_service_type = findViewById(R.id.spinner_post_type);

        servicio_a_ofrecer = findViewById(R.id.servicio_a_of);
        desccripcion = findViewById(R.id.desc_serv);

        String[] types = {getResources().getString(R.string.post_tipo), getResources().getString(R.string.herr), getResources().getString(R.string.serv), getResources().getString(R.string.preg), getResources().getString(R.string.soc)};
        sel = 0;

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, types);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spn_service_type.setAdapter(adapter);
        spn_service_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sel = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tipo = "";
                String titulo = servicio_a_ofrecer.getEditText().getText().toString();
                String desc = desccripcion.getEditText().getText().toString();
                Date fecha = new Date();

                switch (sel) {
                    case 1:
                        tipo = "Herramienta";
                        Servicio s = new Servicio(UserDetails.username, titulo, desc, tipo, fecha);
                        AccesoFirebase.crearPostServicio(s);
                        break;
                    case 2:
                        tipo = "Servicio";
                        Servicio a = new Servicio(UserDetails.username, titulo, desc, tipo, fecha);
                        AccesoFirebase.crearPostServicio(a);
                        break;

                    case 3:
                        tipo = "Pregunta";
                        Pregunta d = new Pregunta(UserDetails.username, titulo, tipo, fecha);
                        AccesoFirebase.crearPostPregunta(d);
                        break;
                    case 4:
                        tipo = "Social";
                        PublicacionSocial ps = new PublicacionSocial(UserDetails.username, titulo, desc, tipo, fecha);
                        AccesoFirebase.crearPostSocial(ps);
                        break;
                }


            }
        });
    }

}
