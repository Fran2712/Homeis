package com.PIFF.Homeis.adaptadores;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
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

    public AdaptadorRecyclerPublicaciones(ArrayList<Publicacion> lista_contactos, MainActivity mainActivity) {
        this.lista_contactos = lista_contactos;
        this.context = mainActivity;
    }

    @NonNull
    @Override
    public ContenedorDeVistas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista_feed, parent, false);
<<<<<<< HEAD:app/src/main/java/com/PIFF/Homeis/AdaptadorRecyclerPublicaciones.java
        TextView tv_titulo = vista.findViewById(R.id.TE_titulo_request);
        TextView tv_autor = vista.findViewById(R.id.TE_autor);
        TextView tv_descrip = vista.findViewById(R.id.TE_descrip);
        TextView tv_fecha = vista.findViewById(R.id.TE_fecha);
=======
        TextView tv_titulo = vista.findViewById(R.id.TV_servicio);
        TextView tv_autor = vista.findViewById(R.id.TV_autor);
        TextView tv_descrip = vista.findViewById(R.id.TV_descrip);
        TextView tv_fecha = vista.findViewById(R.id.TV_fecha);
>>>>>>> 77a49781e731a9cf758daf19b4755f749ab992ed:app/src/main/java/com/PIFF/Homeis/adaptadores/AdaptadorRecyclerPublicaciones.java
        ImageView img_pfp = vista.findViewById(R.id.IMG_pfp);
        ContenedorDeVistas contenedor = new ContenedorDeVistas(vista);
        Log.d("Contenedor","Creando contenedor de vistas");
        vista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

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
<<<<<<< HEAD:app/src/main/java/com/PIFF/Homeis/AdaptadorRecyclerPublicaciones.java
            this.tv_titulo = vista.findViewById(R.id.TE_titulo_request);
            this.tv_autor = vista.findViewById(R.id.TE_autor);
            this.tv_fecha = vista.findViewById(R.id.TE_fecha);
            this.tv_descrip = vista.findViewById(R.id.TE_descrip);
=======
            this.tv_titulo = vista.findViewById(R.id.TV_servicio);
            this.tv_autor = vista.findViewById(R.id.TV_autor);
            this.tv_fecha = vista.findViewById(R.id.TV_fecha);
            this.tv_descrip = vista.findViewById(R.id.TV_descrip);
>>>>>>> 77a49781e731a9cf758daf19b4755f749ab992ed:app/src/main/java/com/PIFF/Homeis/adaptadores/AdaptadorRecyclerPublicaciones.java
            this.img_pfp = vista.findViewById(R.id.IMG_pfp);
        }
    }

}
