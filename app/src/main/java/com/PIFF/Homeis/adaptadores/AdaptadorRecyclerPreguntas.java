package com.PIFF.Homeis.adaptadores;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.Intent;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.PIFF.Homeis.ChatScreen;
import com.PIFF.Homeis.Preguntas_screen;
import com.PIFF.Homeis.R;
import com.PIFF.Homeis.entidad.Pregunta;
import com.PIFF.Homeis.entidad.UserDetails;
import com.PIFF.Homeis.persistencia.AccesoFirebase;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import java.util.ArrayList;

public class AdaptadorRecyclerPreguntas extends RecyclerView.Adapter<AdaptadorRecyclerPreguntas.ContenedorDeVistas> {
    private ArrayList<Pregunta> lista_preguntas;
    private Context context;

    public AdaptadorRecyclerPreguntas(ArrayList<Pregunta> lista_preguntas, Preguntas_screen preguntas_screen) {
        this.lista_preguntas = lista_preguntas;
        this.context = preguntas_screen;
    }

    @NonNull
    @Override
    public ContenedorDeVistas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista_feed_preguntas, parent, false);
        TextView tv_autor = vista.findViewById(R.id.TV_autor);
        TextView tv_pregunta = vista.findViewById(R.id.TV_pregunta);
        ImageView img_pfp = vista.findViewById(R.id.IMG_pfp);
        final LinearLayout hiddenView = vista.findViewById(R.id.hidden_view);
        final CardView cardView = vista.findViewById(R.id.base_cardview);
        final ImageButton arrow= vista.findViewById(R.id.arrow_button);
        ContenedorDeVistas contenedor = new ContenedorDeVistas(vista);

        Button btn_solici= vista.findViewById(R.id.BTN_request);
        btn_solici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!tv_autor.getText().toString().equals(UserDetails.username)) {
                    AccesoFirebase.crearChat(tv_autor.getText().toString());
                    UserDetails.chatWith = tv_autor.getText().toString();
                    Intent intent = new Intent(context, ChatScreen.class);
                    context.startActivity(intent);
                }
            }
        });

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hiddenView.getVisibility() == View.VISIBLE) {
                    hiddenView.setVisibility(View.GONE);
                    arrow.setImageResource(R.drawable.ic_baseline_expand_more_24);
                    vista.getLayoutParams().height= 400;
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                }
                else {

                    hiddenView.setVisibility(View.VISIBLE);
                    arrow.setImageResource(R.drawable.ic_baseline_expand_less_24);
                    vista.getLayoutParams().height=600;
                    TransitionManager.beginDelayedTransition(cardView,new AutoTransition());
                }
            }
        });
        return contenedor;
    }

    @Override
    public void onBindViewHolder(@NonNull ContenedorDeVistas holder, int position) {
        Pregunta c = lista_preguntas.get(position);
        holder.tv_autor.setText(c.getAutor());
        holder.tv_pregunta.setText(c.getPregunta());
        Glide.with(context)
                .load(R.drawable.foto_perfil_ejemplo)
                .centerCrop()
                .circleCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .into(holder.img_pfp);
        Log.d("Contenedor","Cvinculando la posicion" + position);
    }

    @Override
    public int getItemCount() {

        return lista_preguntas.size();
    }

    public static class ContenedorDeVistas extends RecyclerView.ViewHolder {
        public TextView tv_pregunta, tv_autor;
        public ImageView img_pfp;
        public ImageButton arrow;
        private LinearLayout hiddenView;
        private CardView cardView;


        public ContenedorDeVistas(View vista) {
            super(vista);
            this.tv_pregunta = vista.findViewById(R.id.TV_pregunta);
            this.tv_autor = vista.findViewById(R.id.TV_autor);
            this.img_pfp = vista.findViewById(R.id.IMG_pfp);
            this.arrow = vista.findViewById(R.id.arrow_button);
            this.hiddenView = vista.findViewById(R.id.hidden_view);
            this.cardView = vista.findViewById(R.id.base_cardview);
        }
    }

}
