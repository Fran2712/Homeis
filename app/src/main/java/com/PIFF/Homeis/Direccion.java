package com.PIFF.Homeis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.PIFF.Homeis.persistencia.AccesoJsoup;

import java.util.HashMap;
import java.util.List;

public class Direccion extends AppCompatActivity {
    private Button btn_regster;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direccion);
        btn_regster = findViewById(R.id.BTN_regster);
        List<String> lista_paises= AccesoJsoup.obtenerCiudades();
        Log.d("datos",lista_paises.toString());
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