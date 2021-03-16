package com.PIFF.Homeis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.PIFF.Homeis.adaptadores.AdaptadorRecyclerPreguntas;
import com.PIFF.Homeis.entidad.Pregunta;
import com.PIFF.Homeis.persistencia.AccesoFirebase;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;

import java.util.ArrayList;

public class Preguntas_screen extends AppCompatActivity {

    private RecyclerView rec;
    private RecyclerView.LayoutManager gestor2;
    private AdaptadorRecyclerPreguntas adapt;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas_screen);
        rec = findViewById(R.id.RC_preguntas);
        searchView = findViewById(R.id.searchView);

        ArrayList<Pregunta> liata = AccesoFirebase.devolverPostPregunta();

        gestor2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapt = new AdaptadorRecyclerPreguntas(liata,Preguntas_screen.this);
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


        //Search View
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });

        //Listeners Bottom app Bar
        findViewById(R.id.home_menu_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Preguntas_screen.this, MainActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.chat_menu_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Preguntas_screen.this, ChatroomScreen.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.notifi_menu_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Preguntas_screen.this, NotificationsScreen.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Preguntas_screen.this, CreatePost.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.profile_menu_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Preguntas_screen.this, ProfileScreen.class);
                startActivity(intent);
            }
        });



    }

}
