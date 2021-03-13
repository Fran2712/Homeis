package com.PIFF.Homeis.adaptadores;

import android.animation.LayoutTransition;
import android.content.Context;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.PIFF.Homeis.R;
import com.PIFF.Homeis.entidad.Servicio;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import java.util.ArrayList;

public class AdaptadorRecyclerPublicaciones extends RecyclerView.Adapter<AdaptadorRecyclerPublicaciones.ContenedorDeVistas> {
    private ArrayList<Servicio> lista_contactos;
    private Context context;


    public AdaptadorRecyclerPublicaciones(ArrayList<Servicio> lista_contactos, Context c) {
        this.lista_contactos = lista_contactos;
        this.context = c;
    }

    @NonNull
    @Override
    public ContenedorDeVistas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista_feed, parent, false);
        TextView tv_servicio = vista.findViewById(R.id.TV_servicio);
        TextView tv_autor = vista.findViewById(R.id.TV_autor);
        TextView tv_descrip = vista.findViewById(R.id.TV_descrip);
        ImageView img_pfp = vista.findViewById(R.id.IMG_pfp);
        final LinearLayout hiddenView = vista.findViewById(R.id.hidden_view);
        final CardView cardView = vista.findViewById(R.id.base_cardview);
        final ImageButton arrow= vista.findViewById(R.id.arrow_button);

        final Button solic= vista.findViewById(R.id.BTN_request);
        solic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ContenedorDeVistas contenedor = new ContenedorDeVistas(vista);
        Log.d("Contenedor","Creando contenedor de vistas");

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hiddenView.getVisibility() == View.VISIBLE) {
                    hiddenView.setVisibility(View.GONE);
                    arrow.setImageResource(R.drawable.ic_baseline_expand_more_24);
                    vista.getLayoutParams().height= 560;
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                }
                else {

                    hiddenView.setVisibility(View.VISIBLE);
                    arrow.setImageResource(R.drawable.ic_baseline_expand_less_24);
                    vista.getLayoutParams().height=800;
                    TransitionManager.beginDelayedTransition(cardView,new AutoTransition());
                }
            }
        });
        return contenedor;
    }

    @Override
    public void onBindViewHolder(@NonNull ContenedorDeVistas holder, int position) {
        Servicio c = lista_contactos.get(position);
        holder.tv_autor.setText(c.getAutor());
        holder.tv_descrip.setText(c.getDescrip());
        holder.tv_servicio.setText(c.getServicio());
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

        return lista_contactos.size();
    }

    public static class ContenedorDeVistas extends RecyclerView.ViewHolder {
        public TextView  tv_servicio, tv_descrip,tv_autor;
        public ImageView  img_pfp;
        public ImageButton arrow;
        private LinearLayout hiddenView;
        private CardView cardView;


        public ContenedorDeVistas(View vista) {
            super(vista);
            this.tv_servicio = vista.findViewById(R.id.TV_servicio);
            this.tv_autor = vista.findViewById(R.id.TV_autor);
            this.tv_descrip = vista.findViewById(R.id.TV_descrip);
            this.img_pfp =  vista.findViewById(R.id.IMG_pfp);
            this.arrow = vista.findViewById(R.id.arrow_button);
            this.hiddenView = vista.findViewById(R.id.hidden_view);
            this.cardView = vista.findViewById(R.id.base_cardview);
        }
    }

}
