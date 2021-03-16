package com.PIFF.Homeis;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.PIFF.Homeis.entidad.Request;

import java.util.ArrayList;

public class AdaptadorRecyclerRequests extends RecyclerView.Adapter<AdaptadorRecyclerRequests.ContenedorDeVistas> {
    private ArrayList<Request> lista_requests;
    private boolean estado = true;

    public AdaptadorRecyclerRequests(ArrayList<Request> lista_requests) {
        this.lista_requests = lista_requests;
    }

    @NonNull
    @Override
    public ContenedorDeVistas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.requests_card, parent, false);
        TextView request_author = vista.findViewById(R.id.TE_autor);
        TextView request_title = vista.findViewById(R.id.TE_titulo_request);
        TextView request_subtext = vista.findViewById(R.id.TE_descrip);
        TextView request_date = vista.findViewById(R.id.TV_fecha);
        ImageView request_ic = vista.findViewById(R.id.IMG_pfp);
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
        Request r = lista_requests.get(position);
        holder.request_author.setText(r.getRequest_author());
        holder.request_title.setText(r.getRequest_title());
        holder.request_subtext.setText(r.getRequest_subtext());
        holder.request_date.setText(r.getRequest_date().toString());
        Log.d("Contenedor","Vinculando la posicion" + position);
    }

    @Override
    public int getItemCount() {
        return lista_requests.size();
    }

    public static class ContenedorDeVistas extends RecyclerView.ViewHolder {
        public TextView request_author, request_title, request_subtext, request_date;
        public ImageView request_ic;

        public ContenedorDeVistas(View vista) {
            super(vista);
            this.request_author = vista.findViewById(R.id.TE_autor);
            this.request_title = vista.findViewById(R.id.TE_titulo_request);
            this.request_subtext = vista.findViewById(R.id.TE_descrip);
            this.request_date = vista.findViewById(R.id.TV_fecha);
            this.request_ic = vista.findViewById(R.id.IMG_pfp);
        }
    }

}