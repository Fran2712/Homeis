package com.PIFF.Homeis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private View vista;
    private View card1;
    private View card2;
    private View card3;
    private View card4;
    private RecyclerView rec;
    private ImageView ocul;
    private Boolean bajado;
    private TextView tit;
    private TextView txt_card_1;
    private TextView txt_card_2;
    private TextView txt_card_3;
    private TextView txt_card_4;
    private RecyclerView.LayoutManager gestor;
    private RecyclerView.LayoutManager gestor2;
    private  AdaptadorRecyclerPublicaciones adapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rec = findViewById(R.id.recycler_publicaciones);
        ocul = findViewById(R.id.IMG_ocultar);
        vista = findViewById(R.id.vista_contenedor);
        tit = findViewById(R.id.TV_necesi);
        card1 = findViewById(R.id.card_1);
        card2 = findViewById(R.id.card_2);
        card3 = findViewById(R.id.card_3);
        card4 = findViewById(R.id.card_4);
        tit = findViewById(R.id.TV_necesi);
        txt_card_1 = findViewById(R.id.TV_card_1);
        txt_card_2 = findViewById(R.id.TV_card_2);
        txt_card_3 = findViewById(R.id.TV_card_3);
        txt_card_4 = findViewById(R.id.TV_card_4);
        bajado = false;

        Publicacion c1 = new Publicacion("Adolfo Hitzar","El frio es para tanto","hoy he estado en Rusia y necesito que alguien me deje una sierra radial");
        Publicacion c2 = new Publicacion("Benito Moussolano","Se me ha roto la estanteria","Pues eso mnecesito que alguien me ayude a montar la que me comprao del ikea ");

        ArrayList<Publicacion> liata = new ArrayList<>();

        liata.add(c1);
        liata.add(c2);
        gestor = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        gestor2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapt = new AdaptadorRecyclerPublicaciones(liata);
        rec.setAdapter(adapt);
        rec.setLayoutManager(gestor);

        ocul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bajado){
                    vista.animate().translationYBy(+1200).start();
                    ocul.animate().translationYBy(+1200).start();
                    card1.animate().translationYBy(+1200).start();
                    card2.animate().translationYBy(+1200).start();
                    card3.animate().translationYBy(+1200).start();
                    card4.animate().translationYBy(+1200).start();
                    txt_card_1.animate().translationYBy(+1200).start();
                    txt_card_2.animate().translationYBy(+1200).start();
                    txt_card_3.animate().translationYBy(+1200).start();
                    txt_card_4.animate().translationYBy(+1200).start();
                    tit.animate().translationYBy(+1200).start();
                    tit.setVisibility(View.INVISIBLE);

                    rec.setLayoutManager(gestor2);
                    bajado = true;
                }else{
                    vista.animate().translationYBy(-1200).start();
                    ocul.animate().translationYBy(-1200).start();
                    card1.animate().translationYBy(-1200).start();
                    card2.animate().translationYBy(-1200).start();
                    card3.animate().translationYBy(-1200).start();
                    card4.animate().translationYBy(-1200).start();
                    txt_card_1.animate().translationYBy(-1200).start();
                    txt_card_2.animate().translationYBy(-1200).start();
                    txt_card_3.animate().translationYBy(-1200).start();
                    txt_card_4.animate().translationYBy(-1200).start();
                    tit.animate().translationYBy(-1200).start();
                    tit.setVisibility(View.VISIBLE);
                    rec.setLayoutManager(gestor);
                    bajado = false;
                }

            }
        });

    }
}