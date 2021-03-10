package com.PIFF.Homeis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.PIFF.Homeis.adaptadores.AdaptadorRecyclerPublicaciones;
import com.PIFF.Homeis.entidad.Servicio;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CardView vista;
    private CardView card1;
    private CardView card2;
    private CardView card3;
    private CardView card4;


    private RecyclerView rec;
    private ImageView ocul;
    private Boolean bajado;
    private TextView tit;
    private RecyclerView.LayoutManager gestor;
    private RecyclerView.LayoutManager gestor2;
    private AdaptadorRecyclerPublicaciones adapt;


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

        bajado = false;

        vista.setBackgroundResource(R.drawable.shapecard2);
        Servicio c1 = new Servicio("Hugo Duro","Limpio genial","Men encanta limpiar y soy un maniaco de la limpieza, me encanta que todo este bien limpio y colocado donde debe, si quieres te puedo ayudar a limpiar ");
        Servicio c2 = new Servicio("Vegetta777","Electricista gratis xd","Hey muy buenas a todos guapisimos, aqui tengo una aspiradora sin cable por si alguien la quiere");
        Servicio c3 = new Servicio("Arnold","Cocinero","Termine de cavar un hueco en el campo y no voy a usar la pala, si alguien la quiere que me lo diga");

        ArrayList<Servicio> liata = new ArrayList<>();

        liata.add(c1);
        liata.add(c2);
        liata.add(c3);

        gestor = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        gestor2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapt = new AdaptadorRecyclerPublicaciones(liata,MainActivity.this);
        rec.setAdapter(adapt);
        rec.setLayoutManager(gestor);

        //servicios
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ServiciosScreen.class);
                startActivity(intent);
            }
        });
        //herramientas
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HerramientasScreen.class);
                startActivity(intent);
            }
        });
        //preguntas
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Preguntas_screen.class);
                startActivity(intent);
            }
        });
        //social
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SocialScreen.class);
                startActivity(intent);
            }
        });
        ocul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bajado){
                    vista.animate().translationYBy(+1200).start();
                    tit.setVisibility(View.INVISIBLE);
                    rec.setLayoutManager(gestor2);
                    bajado = true;
                }else{
                    vista.animate().translationYBy(-1200).start();
                    tit.setVisibility(View.VISIBLE);
                    rec.animate().alphaBy(1).start();
                    rec.setLayoutManager(gestor);
                    bajado = false;
                }

            }
        });

    }

}