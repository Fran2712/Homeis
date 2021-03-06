package com.PIFF.Homeis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.PIFF.Homeis.adaptadores.AdaptadorRecyclerPublicaciones;
import com.PIFF.Homeis.entidad.Servicio;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;

import java.util.ArrayList;

public class ServiciosScreen extends AppCompatActivity {

    private RecyclerView rec;
    private RecyclerView.LayoutManager gestor2;
    private AdaptadorRecyclerPublicaciones adapt;
    private CoordinatorLayout coo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios_screen);
        rec = findViewById(R.id.RC_servivios);
        coo = findViewById(R.id.coordinator);

        Servicio c1 = new Servicio("Mandarina","Li,pio genial","Por si acaso necesitas una sierra radial poes eso, yo se la dejo");
        Servicio c2 = new Servicio("Vegetta777","Electricista gratis xd","Hey muy buenas a todos guapisimos, aqui tengo una aspiradora sin cable por si alguien la quiere");
        Servicio c3 = new Servicio("Arnold","Cocinero","Termine de cavar un hueco en el campo y no voy a usar la pala, si alguien la quiere que me lo diga");

        ArrayList<Servicio> liata = new ArrayList<>();

        liata.add(c1);
        liata.add(c2);
        liata.add(c3);

        gestor2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapt = new AdaptadorRecyclerPublicaciones(liata, ServiciosScreen.this);
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