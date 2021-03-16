package com.PIFF.Homeis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.PIFF.Homeis.adaptadores.AdaptadorRecyclerPublicaciones;
import com.PIFF.Homeis.adaptadores.AdaptadorRecyclerSocial;
import com.PIFF.Homeis.entidad.PublicacionSocial;
import com.PIFF.Homeis.entidad.Servicio;
import com.PIFF.Homeis.persistencia.AccesoFirebase;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;

import java.util.ArrayList;
import java.util.Date;

public class SocialScreen extends AppCompatActivity{

    private RecyclerView rec;
    private RecyclerView.LayoutManager gestor2;
    private AdaptadorRecyclerSocial adapt;
    private CoordinatorLayout coo;
    private  ArrayList<PublicacionSocial> liata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_screen);
        rec = findViewById(R.id.RC_servivios);
        coo = findViewById(R.id.coordinator);

       ArrayList<PublicacionSocial> liata = AccesoFirebase.devolverPostSocial();


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

        //Listeners Bottom app Bar
        findViewById(R.id.home_menu_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SocialScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.chat_menu_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SocialScreen.this, ChatroomScreen.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.notifi_menu_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SocialScreen.this, NotificationsScreen.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SocialScreen.this, CreatePost.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.profile_menu_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SocialScreen.this, ProfileScreen.class);
                startActivity(intent);
            }
        });




    }

}