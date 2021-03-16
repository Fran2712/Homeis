package com.PIFF.Homeis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import com.PIFF.Homeis.adaptadores.AdaptadorRecyclerPublicaciones;
import com.PIFF.Homeis.adaptadores.AdaptadorRecyclerServicios;
import com.PIFF.Homeis.entidad.Publicacion;
import com.PIFF.Homeis.entidad.Servicio;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;

import java.util.ArrayList;
import java.util.Date;

public class ServiciosScreen extends AppCompatActivity {

    private RecyclerView rec;
    private RecyclerView.LayoutManager gestor2;
    private AdaptadorRecyclerServicios adapt;
    private CoordinatorLayout coo;
    private SearchView search_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios_screen);
        rec = findViewById(R.id.RC_servivios);
        coo = findViewById(R.id.coordinator);
        search_bar = findViewById(R.id.searchView);

        Servicio c1 = new Servicio("Mandarina","Li,pio genial","Por si acaso necesitas una sierra radial poes eso, yo se la dejo");
        Servicio c2 = new Servicio("Vegetta777","Electricista gratis xd","Hey muy buenas a todos guapisimos, aqui tengo una aspiradora sin cable por si alguien la quiere");
        Servicio c3 = new Servicio("Arnold","Cocinero","Termine de cavar un hueco en el campo y no voy a usar la pala, si alguien la quiere que me lo diga");

        ArrayList<Servicio> liata = new ArrayList<>();

        liata.add(c1);
        liata.add(c2);
        liata.add(c3);

        gestor2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapt = new AdaptadorRecyclerServicios(liata, ServiciosScreen.this);
        rec.setAdapter(adapt);
        rec.setLayoutManager(gestor2);

        search_bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_bar.setVisibility(View.VISIBLE);
            }
        });


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