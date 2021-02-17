package com.PIFF.Homeis.persistencia;

import android.util.Log;

import androidx.annotation.NonNull;

import com.PIFF.Homeis.entidad.Usuario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AccesoFirebase {
    public static ArrayList<Usuario> usuariosBBDD= new ArrayList<Usuario>();
    public static DatabaseReference conexionBBDD(){
        FirebaseDatabase bd = FirebaseDatabase.getInstance();
        DatabaseReference ref = bd.getReference("Usuarios");
        return ref;
    }
    public static void altaUsuario(Usuario usuario) {
        DatabaseReference ref = conexionBBDD();
        ref.push().setValue(usuario);
    }
    public static List<Usuario> devolverUsuarios() {
        DatabaseReference ref = conexionBBDD();
        final boolean[] existente = {false};
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Iterable<DataSnapshot> datos = snapshot.getChildren();
                for (DataSnapshot d:datos) {
                    Usuario userBBDD = d.getValue(Usuario.class);
                    usuariosBBDD.add(userBBDD);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("ERROR",error.getMessage());
            }
        });

        return usuariosBBDD;
    }

    public static boolean comprobarUsuario(String user_email) {
        for (Usuario u: usuariosBBDD) {
            if (u.getEmail().equals(user_email)){
                return true;
            }
        }
        return false;
    }
}
