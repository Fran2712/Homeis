package com.PIFF.Homeis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.PIFF.Homeis.adaptadores.AdaptadorRecyclerPreguntas;
import com.PIFF.Homeis.adaptadores.AdaptadorRecyclerPublicaciones;
import com.PIFF.Homeis.entidad.Pregunta;
import com.PIFF.Homeis.entidad.Publicacion;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;

import java.util.ArrayList;
import java.util.Date;

public class Preguntas_screen extends AppCompatActivity {

    private RecyclerView rec;
    private RecyclerView.LayoutManager gestor2;
    private AdaptadorRecyclerPreguntas adapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas_screen);
        rec = findViewById(R.id.RC_preguntas);

        Pregunta p1 = new Pregunta("Adefesio ","Alguien sabe como empalmar 2 cables?");
        Pregunta p2 = new Pregunta("Marina ","Algun metodo to guapo pa levantar el parqué");
        Pregunta p3 = new Pregunta("Pablo ","A que dia y hora pasa el recogebasura??");

        ArrayList<Pregunta> liata = new ArrayList<>();

        liata.add(p1);
        liata.add(p2);
        liata.add(p3);


        gestor2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapt = new AdaptadorRecyclerPreguntas(liata);
        rec.setAdapter(adapt);
        rec.setLayoutManager(gestor2);

        gestor2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapt = new AdaptadorRecyclerPreguntas(liata);
        rec.setAdapter(adapt);
        rec.setLayoutManager(gestor2);

        //Borde redondo bottom app bar
        float radius = 80;
        BottomAppBar bottomAppBar = findViewById(R.id.bottom_app_bar);

        MaterialShapeDrawable bottomBarBackground = (MaterialShapeDrawable) bottomAppBar.getBackground();
        bottomBarBackground.setShapeAppearanceModel(
                bottomBarBackground.getShapeAppearanceModel()
                        .toBuilder()
                        .setTopRightCorner(CornerFamily.ROUNDED,radius)
                        .setTopLeftCorner(CornerFamily.ROUNDED,radius)
                        .build());


    }
}
