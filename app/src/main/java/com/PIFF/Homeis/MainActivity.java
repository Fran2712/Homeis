package com.PIFF.Homeis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.PIFF.Homeis.entidad.Publicacion;

import java.util.ArrayList;
import java.util.Date;

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
    private  ImageView img_serv;
    private  ImageView img_preg;
    private  ImageView img_herr;
    private  ImageView img_social;

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

        img_serv = findViewById(R.id.IMG_serv);
        img_preg = findViewById(R.id.IMG_preg);
        img_herr = findViewById(R.id.IMG_herr);
        img_social = findViewById(R.id.IMG_social);

        bajado = false;

        Publicacion c1 = new Publicacion("Adolfo","Necesito a una motosierra","hoy he estado en Rusia y necesito que alguien me deje una sierra radial",new Date());
        Publicacion c2 = new Publicacion("Benito ","Necesito un Manitas","Pues eso mnecesito que alguien me ayude a montar la que me comprao del ikea", new Date());

        ArrayList<Publicacion> liata = new ArrayList<>();

        liata.add(c1);
        liata.add(c2);
        gestor = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        gestor2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapt = new AdaptadorRecyclerPublicaciones(liata);
        rec.setAdapter(adapt);
        rec.setLayoutManager(gestor);
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ServiciosScreen.class);
                startActivity(intent);
            }
        });

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
                    img_serv.animate().translationYBy(+1200).start();
                    img_preg.animate().translationYBy(+1200).start();
                    img_herr.animate().translationYBy(+1200).start();
                    img_social.animate().translationYBy(+1200).start();
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
                    img_serv.animate().translationYBy(-1200).start();
                    img_preg.animate().translationYBy(-1200).start();
                    img_herr.animate().translationYBy(-1200).start();
                    img_social.animate().translationYBy(-1200).start();
                    tit.setVisibility(View.VISIBLE);
                    rec.animate().alphaBy(1).start();
                    rec.setLayoutManager(gestor);
                    bajado = false;
                }

            }
        });

    }

}