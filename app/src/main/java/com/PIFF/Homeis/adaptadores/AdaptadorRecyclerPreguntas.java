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
import com.PIFF.Homeis.entidad.Pregunta;
import com.PIFF.Homeis.entidad.Publicacion;

import java.util.ArrayList;

public class AdaptadorRecyclerPreguntas extends RecyclerView.Adapter<AdaptadorRecyclerPreguntas.ContenedorDeVistas> {
    private ArrayList<Pregunta> lista_preguntas;

    public AdaptadorRecyclerPreguntas(ArrayList<Pregunta> lista_preguntas) {
        this.lista_preguntas = lista_preguntas;
    }

    @NonNull
    @Override
    public ContenedorDeVistas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista_feed_preguntas, parent, false);
        TextView tv_autor = vista.findViewById(R.id.TV_autor);
        TextView tv_pregunta = vista.findViewById(R.id.TV_pregunta);
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
        Pregunta c = lista_preguntas.get(position);
        holder.tv_autor.setText(c.getAutor());
        holder.tv_pregunta.setText(c.getPregunta());

        Log.d("Contenedor","Cvinculando la posicion" + position);
    }

    @Override
    public int getItemCount() {

        return lista_preguntas.size();
    }

    public static class ContenedorDeVistas extends RecyclerView.ViewHolder {
        public TextView tv_pregunta, tv_autor;
        public ImageView img_pfp;

        public ContenedorDeVistas(View vista) {
            super(vista);
            this.tv_pregunta = vista.findViewById(R.id.TV_pregunta);
            this.tv_autor = vista.findViewById(R.id.TV_autor);
            this.img_pfp = vista.findViewById(R.id.IMG_pfp);
        }
    }

}
