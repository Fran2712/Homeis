package com.PIFF.Homeis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.PIFF.Homeis.adaptadores.AdaptadorRecyclerServicios;
import com.PIFF.Homeis.adaptadores.AdaptadorRecyclerSocial;
import com.PIFF.Homeis.entidad.PublicacionSocial;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;

import java.util.ArrayList;
import java.util.Date;

public class SocialScreen extends AppCompatActivity {

    private RecyclerView rec;
    private RecyclerView.LayoutManager gestor2;
    private AdaptadorRecyclerSocial adapt;
    private CoordinatorLayout coo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_screen);
        rec = findViewById(R.id.RC_servivios);
        coo = findViewById(R.id.coordinator);
        PublicacionSocial c1 = new PublicacionSocial("Mandarina","Algun restaurante top por la zona?","Por si acaso necesitas una sierra radial poes eso, yo se la dejo",new Date());
        PublicacionSocial c2 = new PublicacionSocial("Vegetta777","Alguien para un partidillo?","Hey muy buenas a todos guapisimos, aqui tengo una aspiradora sin cable por si alguien la quiere",new Date());
        PublicacionSocial c3 = new PublicacionSocial("Arnold","Estudia conmigo!","Termine de cavar un hueco en el campo y no voy a usar la pala, si alguien la quiere que me lo diga",new Date());

        ArrayList<PublicacionSocial> liata = new ArrayList<>();

        liata.add(c1);
        liata.add(c2);
        liata.add(c3);

        gestor2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapt = new AdaptadorRecyclerSocial(liata, SocialScreen.this);
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