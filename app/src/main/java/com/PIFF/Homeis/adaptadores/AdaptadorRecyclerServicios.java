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
import com.PIFF.Homeis.entidad.Servicio;

import java.util.ArrayList;

public class AdaptadorRecyclerServicios extends RecyclerView.Adapter<AdaptadorRecyclerServicios.ContenedorDeVistas> {
    private ArrayList<Servicio> lista_contactos;
    private boolean estado = true;

    public AdaptadorRecyclerServicios(ArrayList<Servicio> lista_contactos) {
        this.lista_contactos = lista_contactos;
    }

    @NonNull
    @Override
    public ContenedorDeVistas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista_feed_servicio, parent, false);
        TextView tv_servicio = vista.findViewById(R.id.TV_servicio);
        TextView tv_autor = vista.findViewById(R.id.TV_autor);
        TextView tv_descrip = vista.findViewById(R.id.TV_descrip);
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
        Servicio c = lista_contactos.get(position);
        holder.tv_autor.setText(c.getAutor());
        holder.tv_descrip.setText(c.getDescrip());
        holder.tv_servicio.setText(c.getServicio());
        Log.d("Contenedor","Cvinculando la posicion" + position);
    }

    @Override
    public int getItemCount() {

        return lista_contactos.size();
    }

    public static class ContenedorDeVistas extends RecyclerView.ViewHolder {
        public TextView  tv_servicio, tv_descrip,tv_autor;

        public ContenedorDeVistas(View vista) {
            super(vista);
            this.tv_servicio = vista.findViewById(R.id.TV_servicio);
            this.tv_autor = vista.findViewById(R.id.TV_autor);
            this.tv_descrip = vista.findViewById(R.id.TV_descrip);
        }
    }

}
