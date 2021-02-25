package com.PIFF.Homeis;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.PIFF.Homeis.entidad.Notificacion;
import com.PIFF.Homeis.entidad.Request;

import java.util.ArrayList;

public class AdaptadorRecyclerNotification extends RecyclerView.Adapter<AdaptadorRecyclerNotification.ContenedorDeVistas> {
    private ArrayList<Notificacion> lista_notificaciones;
    private boolean estado = true;

    public AdaptadorRecyclerNotification(ArrayList<Notificacion> lista_notificaciones) {
        this.lista_notificaciones = lista_notificaciones;
    }

    @NonNull
    @Override
    public ContenedorDeVistas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_card, parent, false);
        TextView notif_title = vista.findViewById(R.id.notif_title_txt);
        TextView notif_subtxt = vista.findViewById(R.id.notif_subtext);
        TextView notif_type = vista.findViewById(R.id.notif_type);
        TextView notif_date = vista.findViewById(R.id.notif_date);
        TextView notif_ic = vista.findViewById(R.id.notif_ic);
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
        Notificacion n = lista_notificaciones.get(position);
        holder.notif_title.setText(n.getNombre_user());
        holder.notif_subtxt.setText(n.getSub_text());
        holder.notif_type.setText(n.getNotification_type());
        holder.notif_date.setText(n.getDate().toString());
        Log.d("Contenedor","Vinculando la posicion" + position);
    }

    @Override
    public int getItemCount() {
        return lista_notificaciones.size();
    }

    public static class ContenedorDeVistas extends RecyclerView.ViewHolder {
        public TextView notif_title, notif_subtxt, notif_type ,notif_date;
        public ImageView notif_ic;

        public ContenedorDeVistas(View vista) {
            super(vista);
            this.notif_title = vista.findViewById(R.id.notif_title_txt);
            this.notif_subtxt = vista.findViewById(R.id.notif_subtext);
            this.notif_type = vista.findViewById(R.id.notif_type);
            this.notif_date = vista.findViewById(R.id.notif_date);
            this.notif_ic = vista.findViewById(R.id.notif_ic);
        }
    }

}