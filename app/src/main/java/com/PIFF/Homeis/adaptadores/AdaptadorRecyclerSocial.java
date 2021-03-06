package com.PIFF.Homeis.adaptadores;

import android.animation.LayoutTransition;
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

import com.PIFF.Homeis.R;
import com.PIFF.Homeis.SocialScreen;
import com.PIFF.Homeis.entidad.PublicacionSocial;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import java.util.ArrayList;

public class AdaptadorRecyclerSocial extends RecyclerView.Adapter<AdaptadorRecyclerSocial.ContenedorDeVistas> {
    private ArrayList<PublicacionSocial> lista_contactos;
    private Context context;

    public AdaptadorRecyclerSocial(ArrayList<PublicacionSocial> lista_contactos, SocialScreen socialScreen) {
        this.lista_contactos = lista_contactos;
        this.context = socialScreen;
    }

    @NonNull
    @Override
    public ContenedorDeVistas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista_feed_social, parent, false);
        TextView tv_titulo = vista.findViewById(R.id.TV_titulo);
        TextView tv_autor = vista.findViewById(R.id.TV_autor);
        TextView tv_descrip = vista.findViewById(R.id.TV_descrip);
        TextView tv_fecha = vista.findViewById(R.id.TV_fecha);
        ImageView img_pfp = vista.findViewById(R.id.IMG_pfp);
        final LinearLayout hiddenView = vista.findViewById(R.id.hidden_view);
        final CardView cardView = vista.findViewById(R.id.base_cardview);
        final ImageButton arrow= vista.findViewById(R.id.arrow_button);
        ContenedorDeVistas contenedor = new ContenedorDeVistas(vista);
        Log.d("Contenedor","Creando contenedor de vistas");

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hiddenView.getVisibility() == View.VISIBLE) {
                    hiddenView.setVisibility(View.GONE);
                    arrow.setImageResource(R.drawable.ic_baseline_expand_more_24);
                    ((ViewGroup)vista).getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
                    vista.getLayoutParams().height= 560;
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                }
                else {

                    hiddenView.setVisibility(View.VISIBLE);
                    arrow.setImageResource(R.drawable.ic_baseline_expand_less_24);
                    ((ViewGroup)vista).getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
                    vista.getLayoutParams().height=800;

                    TransitionManager.beginDelayedTransition(cardView,new AutoTransition());
                }
            }
        });
        return contenedor;
    }

    @Override
    public void onBindViewHolder(@NonNull ContenedorDeVistas holder, int position) {
        PublicacionSocial c = lista_contactos.get(position);
        holder.tv_titulo.setText(c.getTitulo());
        holder.tv_autor.setText(c.getAutor());
        holder.tv_descrip.setText(c.getDescrip());
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
        public ImageButton arrow;
        private LinearLayout hiddenView;
        private CardView cardView;


        public ContenedorDeVistas(View vista) {
            super(vista);
            this.tv_titulo = vista.findViewById(R.id.TV_titulo);
            this.tv_autor = vista.findViewById(R.id.TV_autor);
            this.tv_fecha = vista.findViewById(R.id.TV_fech);
            this.tv_descrip = vista.findViewById(R.id.TV_desc);
            this.img_pfp = vista.findViewById(R.id.IMG_pfp);
            this.arrow = vista.findViewById(R.id.arrow_button);
            this.hiddenView = vista.findViewById(R.id.hidden_view);
            this.cardView = vista.findViewById(R.id.base_cardview);
        }
    }

}
