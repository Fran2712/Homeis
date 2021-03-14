package com.PIFF.Homeis.persistencia;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.PIFF.Homeis.HerramientasScreen;
import com.PIFF.Homeis.SocialScreen;
import com.PIFF.Homeis.entidad.Pregunta;
import com.PIFF.Homeis.entidad.PublicacionSocial;
import com.PIFF.Homeis.entidad.Servicio;
import com.PIFF.Homeis.entidad.UserDetails;
import com.PIFF.Homeis.LoginScreen;
import com.PIFF.Homeis.RegisterScreen;
import com.PIFF.Homeis.entidad.Direccion;
import com.PIFF.Homeis.entidad.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AccesoFirebase {

    private static FirebaseDatabase bd;
    private static DatabaseReference ref;


    public static ArrayList<Usuario> usuariosBBDD= new ArrayList<Usuario>();

    public static ArrayList<Servicio> postServHerr= new ArrayList<Servicio>();
    public static ArrayList<Servicio> postServ= new ArrayList<Servicio>();

    public static ArrayList<Pregunta> postPreg= new ArrayList<Pregunta>();
    public static ArrayList<PublicacionSocial> postSoci= new ArrayList<PublicacionSocial>();

    public static DatabaseReference conexionBBDD(){
        bd = FirebaseDatabase.getInstance();
        ref = bd.getReference("Usuarios");
        return ref;
    }
    public static void altaUsuario(Usuario usuario) {
        DatabaseReference ref = conexionBBDD();
        ref.child(usuario.getEmail().replace(".","")).setValue(usuario);
    }
    public static void devolverUsuarios(LoginScreen llamante,RegisterScreen llamante2) {
        DatabaseReference ref = conexionBBDD();
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
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
        if (llamante!=null){
            llamante.devolverUsuarios(usuariosBBDD);
        }else{
            llamante2.devolverUsuarios(usuariosBBDD);
        }

    }

    public static boolean comprobarUsuario(String user_email) {
        for (Usuario u: usuariosBBDD) {
            if (u.getEmail().equals(user_email)){
                return true;
            }
        }
        return false;
    }

    public static void eliminarUsuario(Usuario user) {
        DatabaseReference mDatabase =conexionBBDD().child(user.getEmail());
    }

    public static boolean comprobarLogin(String user_email, String user_pass) {
        for (Usuario u: usuariosBBDD) {
            if (u.getEmail().equals(user_email) && u.getPassword().equals(user_pass)){
                UserDetails.username = u.getUsername();
                return true;
            }
        }
        return false;
    }
    public static void crearPostServicio(Servicio s) {
        double d = Math.random();
        ref = bd.getReference("Publicaciones-Servicios");
        ref.child(s.getAutor() + "-" + String.valueOf(d).replace(".","Z")).setValue(s);
    }

    public static ArrayList<Servicio> devolverPostServicio(String tipo) {
        bd = FirebaseDatabase.getInstance();
        ref = bd.getReference("Publicaciones-Servicios");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (tipo.equals("Herramienta")) {
                    postServHerr.clear();

                }else {
                    postServ.clear();
                }

                Iterable<DataSnapshot> datos = snapshot.getChildren();
                for (DataSnapshot d:datos) {
                    Servicio s = d.getValue(Servicio.class);
                    if (tipo.equals("Herramienta")) {
                        if (s.getTipo().equals(tipo) ) {
                            postServHerr.add(s);
                        }

                    }else if (tipo.equals("Servicio")){
                        if (s.getTipo().equals(tipo)) {
                            postServ.add(s);
                        }
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("ERROR",error.getMessage());
            }
        });
        if (tipo.equals("Herramienta")) {
            return postServHerr;
        }else {
            return postServ;
        }
    }


    public static void crearPostSocial(PublicacionSocial s) {
        double d = Math.random();
        ref = bd.getReference("Publicaciones-Social");
        ref.child(s.getAutor() + "-" + String.valueOf(d).replace(".","Z")).setValue(s);
    }

    public static ArrayList<PublicacionSocial> devolverPostSocial() {
        bd = FirebaseDatabase.getInstance();
        ref = bd.getReference("Publicaciones-Social");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                postSoci.clear();
                Iterable<DataSnapshot> datos = snapshot.getChildren();
                for (DataSnapshot d:datos) {
                    PublicacionSocial s = d.getValue(PublicacionSocial.class);
                    postSoci.add(s);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("ERROR",error.getMessage());
            }
        });

        return postSoci;
    }

    public static void crearPostPregunta(Pregunta s) {
        double d = Math.random();
        ref = bd.getReference("Publicaciones-Pregunta");
        ref.child(s.getAutor() + "-" + String.valueOf(d).replace(".","Z")).setValue(s);
    }
    public static ArrayList<Pregunta> devolverPostPregunta() {
        bd = FirebaseDatabase.getInstance();
        ref = bd.getReference("Publicaciones-Pregunta");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                postPreg.clear();
                Iterable<DataSnapshot> datos = snapshot.getChildren();
                for (DataSnapshot d:datos) {
                    Pregunta s = d.getValue(Pregunta.class);
                    postPreg.add(s);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("ERROR",error.getMessage());
            }
        });

        return postPreg;
    }

    public static void crearChat(String usuario){
        bd = FirebaseDatabase.getInstance();
        ref = bd.getReference("mensajes");
        ref.child(UserDetails.username + "_" + usuario).push();

    }

    public static void registrarUsuario(final FirebaseAuth firebaseAuth, Usuario user) {
        firebaseAuth.createUserWithEmailAndPassword(user.getEmail(),user.getPassword())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            firebaseAuth.getCurrentUser().sendEmailVerification();
                        }else{
                            Log.d("error","error");
                        }
                    }
                });
    }
    public interface InterfazFirebase{
        public void devolverUsuarios(List<Usuario> usuariosBBDD);
    }
}
