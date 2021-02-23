package com.PIFF.Homeis.adaptadores;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.PIFF.Homeis.R;
import com.PIFF.Homeis.entidad.Publicacion;

import java.util.ArrayList;

public class AdaptadorRecyclerPublicaciones extends RecyclerView.Adapter<AdaptadorRecyclerPublicaciones.ContenedorDeVistas> {
    private ArrayList<Publicacion> lista_contactos;
    private boolean estado = true;

    public AdaptadorRecyclerPublicaciones(ArrayList<Publicacion> lista_contactos) {
        this.lista_contactos = lista_contactos;
    }

    @NonNull
    @Override
    public ContenedorDeVistas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista_feed, parent, false);
        TextView tv_titulo = vista.findViewById(R.id.TV_servicio);
        TextView tv_autor = vista.findViewById(R.id.TV_autor);
        TextView tv_descrip = vista.findViewById(R.id.TV_pregunta);
        TextView tv_fecha = vista.findViewById(R.id.TV_fecha);
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
            this.tv_titulo = vista.findViewById(R.id.TV_servicio);
            this.tv_autor = vista.findViewById(R.id.TV_autor);
            this.tv_fecha = vista.findViewById(R.id.TV_fecha);
            this.tv_descrip = vista.findViewById(R.id.TV_pregunta);
            this.img_pfp = vista.findViewById(R.id.IMG_pfp);
        }
    }

}
