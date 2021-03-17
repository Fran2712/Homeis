package com.PIFF.Homeis;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


import com.PIFF.Homeis.cifrado.ResumenHash;
import com.PIFF.Homeis.entidad.Pregunta;
import com.PIFF.Homeis.entidad.PublicacionSocial;
import com.PIFF.Homeis.entidad.UserDetails;
import com.PIFF.Homeis.entidad.Usuario;
import com.PIFF.Homeis.persistencia.AccesoFirebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginScreen extends AppCompatActivity implements AccesoFirebase.InterfazFirebase {
    private Button btn_login;
    private TextView txt_reg;
    private TextInputLayout ed_email,ed_pass;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = findViewById(R.id.BTN_login);
        ed_email = (TextInputLayout)findViewById(R.id.ED_email);
        ed_pass = (TextInputLayout)findViewById(R.id.ED_pass);
        firebaseAuth=FirebaseAuth.getInstance();
        ed_email.getEditText().addTextChangedListener(validarCampos);
        ed_pass.getEditText().addTextChangedListener(validarCampos);
        btn_login.setEnabled(false);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccesoFirebase.devolverPostSocial();
                AccesoFirebase.devolverPostPregunta();
                AccesoFirebase.devolverPostServicio("Herramienta");
                AccesoFirebase.devolverPostServicio("Servicio");

                AccesoFirebase.devolverUsuarios(LoginScreen.this,null);
            }
        });

        txt_reg = findViewById(R.id.txt_reg2);
        txt_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginScreen.this, RegisterScreen.class);
                startActivity(intent);

            }
        });


    }
    private TextWatcher validarCampos= new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String email = ed_email.getEditText().getText().toString();
            String pass = ed_pass.getEditText().getText().toString();
            boolean validado = comprobarCampos(email,pass);
            btn_login.setEnabled(validado);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private boolean comprobarCampos(String email, String pass) {
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
        if(email.isEmpty()){
            ed_email.getEditText().setError("Campo vacio!");
            if(mather.find() == false){
                ed_email.getEditText().setError("Email inválido!");
            }
            return false;
        }else if(pass.isEmpty()){
            ed_pass.getEditText().setError("Campo vacio!");
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void devolverUsuarios(List<Usuario> usuariosBBDD) {
        String pass_cifrada = ResumenHash.cifrarPassword(ed_pass.getEditText().getText().toString());
        boolean usuario_existente = AccesoFirebase.comprobarLogin(ed_email.getEditText().getText().toString(),pass_cifrada);
        if(usuario_existente || firebaseAuth.getCurrentUser() != null ){
            firebaseAuth.signInWithEmailAndPassword(ed_email.getEditText().getText().toString(),ed_pass.getEditText().getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                if(firebaseAuth.getCurrentUser().isEmailVerified()){
                                    Intent intent = new Intent(LoginScreen.this, MainActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(LoginScreen.this,"Por favor, verifica tu email",Toast.LENGTH_LONG).show();
                                }
                            }else{
                                Log.e("error",task.getException().getLocalizedMessage());
                            }
                        }
                    });

        }else{
           Toast.makeText(LoginScreen.this,"El usuario no existe",Toast.LENGTH_LONG).show();
        }
    }
}
