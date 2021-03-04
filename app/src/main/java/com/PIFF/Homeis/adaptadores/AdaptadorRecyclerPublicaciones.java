package com.PIFF.Homeis.adaptadores;

import android.content.Context;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.PIFF.Homeis.MainActivity;
import com.PIFF.Homeis.R;
import com.PIFF.Homeis.entidad.Publicacion;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import java.util.ArrayList;

public class AdaptadorRecyclerPublicaciones extends RecyclerView.Adapter<AdaptadorRecyclerPublicaciones.ContenedorDeVistas> {
    private ArrayList<Publicacion> lista_contactos;
    private Context context;
    private ImageButton arrow;
    private LinearLayout hiddenView;
    private CardView cardView;

    public AdaptadorRecyclerPublicaciones(ArrayList<Publicacion> lista_contactos, MainActivity mainActivity) {
        this.lista_contactos = lista_contactos;
        this.context = mainActivity;
    }

    @NonNull
    @Override
    public ContenedorDeVistas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista_feed_pruebas, parent, false);
        TextView tv_titulo = vista.findViewById(R.id.TE_titulo_request);
        TextView tv_autor = vista.findViewById(R.id.TE_autor);
        TextView tv_descrip = vista.findViewById(R.id.TE_descrip);
        TextView tv_fecha = vista.findViewById(R.id.TV_fecha);
        ImageView img_pfp = vista.findViewById(R.id.IMG_pfp);
        ContenedorDeVistas contenedor = new ContenedorDeVistas(vista);
        Log.d("Contenedor","Creando contenedor de vistas");

        cardView = vista.findViewById(R.id.base_cardview);
        arrow = vista.findViewById(R.id.arrow_button);
        hiddenView = vista.findViewById(R.id.hidden_view);

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // If the CardView is already expanded, set its visibility
                //  to gone and change the expand less icon to expand more.
                if (hiddenView.getVisibility() == View.VISIBLE) {

                    // The transition of the hiddenView is carried out
                    //  by the TransitionManager class.
                    // Here we use an object of the AutoTransition
                    // Class to create a default transition.
                    TransitionManager.beginDelayedTransition(cardView,
                            new AutoTransition());
                    hiddenView.setVisibility(View.GONE);
                    arrow.setImageResource(R.drawable.ic_baseline_expand_more_24);
                }

                // If the CardView is not expanded, set its visibility
                // to visible and change the expand more icon to expand less.
                else {

                    TransitionManager.beginDelayedTransition(cardView,
                            new AutoTransition());
                    hiddenView.setVisibility(View.VISIBLE);
                    arrow.setImageResource(R.drawable.ic_baseline_expand_less_24);
                }
            }
        });
        return contenedor;
    }

    @Override
    public void onBindViewHolder(@NonNull ContenedorDeVistas holder, int position) {
        Publicacion c = lista_contactos.get(position);
        holder.tv_titulo.setText(c.getTitulo());
        holder.tv_autor.setText(c.getAutor());
        holder.tv_descrip.setText(String.valueOf(c.getDescripcion()));
        holder.tv_fecha.setText(c.getFecha().toString());
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
        public TextView tv_titulo, tv_autor, tv_descrip,tv_fecha;
        public ImageView img_pfp;

        public ContenedorDeVistas(View vista) {
            super(vista);
            this.tv_titulo = vista.findViewById(R.id.TE_titulo_request);
            this.tv_autor = vista.findViewById(R.id.TE_autor);
            this.tv_fecha = vista.findViewById(R.id.TV_fecha);
            this.tv_descrip = vista.findViewById(R.id.TE_descrip);
            this.img_pfp = vista.findViewById(R.id.IMG_pfp);
        }
    }

}
