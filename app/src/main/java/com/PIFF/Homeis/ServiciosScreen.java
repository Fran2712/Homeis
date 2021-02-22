package com.PIFF.Homeis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.PIFF.Homeis.entidad.Publicacion;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;

import java.util.ArrayList;
import java.util.Date;

public class ServiciosScreen extends AppCompatActivity {

    private RecyclerView rec;
    private RecyclerView.LayoutManager gestor2;
    private  AdaptadorRecyclerPublicaciones adapt;
    private CoordinatorLayout coo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios_screen);
        rec = findViewById(R.id.RC_servicios);
        coo = findViewById(R.id.coordinator);

        Publicacion c1 = new Publicacion("Adolfo","Soy manitas","Si necesitas que te arregle algo de interes general contacta conmigo!",new Date());
        Publicacion c2 = new Publicacion("Benito ","Fontanero en tu zona","Pues esosoy fontanero y arreglo cosas de fontanero", new Date());
        Publicacion c3 = new Publicacion("Adelina ","Montadora de Ikea","Soy una máquina montando cosas de ikea, llamammeee!!", new Date());
        Publicacion c4 = new Publicacion("Benito ","Fontanero en tu zona","Pues esosoy fontanero y arreglo cosas de fontanero", new Date());
        Publicacion c5 = new Publicacion("Adelina ","Montadora de Ikea","Soy una máquina montando cosas de ikea, llamammeee!!", new Date());

        ArrayList<Publicacion> liata = new ArrayList<>();

        liata.add(c1);
        liata.add(c2);
        liata.add(c3);
        liata.add(c4);
        liata.add(c5);

        gestor2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapt = new AdaptadorRecyclerPublicaciones(liata);
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