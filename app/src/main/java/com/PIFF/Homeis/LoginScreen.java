package com.PIFF.Homeis;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.PIFF.Homeis.cifrado.ResumenHash;
import com.PIFF.Homeis.entidad.Usuario;
import com.PIFF.Homeis.persistencia.AccesoFirebase;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginScreen extends AppCompatActivity {
    private Button btn_login;
    private TextView txt_reg;
    private TextInputLayout ed_email,ed_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_login = findViewById(R.id.BTN_login);
        ed_email = (TextInputLayout)findViewById(R.id.ED_email);
        ed_pass = (TextInputLayout)findViewById(R.id.ED_pass);
        ed_email.getEditText().addTextChangedListener(validarCampos);
        ed_pass.getEditText().addTextChangedListener(validarCampos);
        btn_login.setEnabled(false);
        AccesoFirebase.devolverUsuarios();
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario user = new Usuario(ed_email.getEditText().getText().toString(),ed_pass.getEditText().getText().toString());
                List<Usuario> usuariosBBDD= AccesoFirebase.devolverUsuarios();
                String pass_cifrada = ResumenHash.cifrarPassword(ed_pass.getEditText().getText().toString());
                boolean usuario_existente = AccesoFirebase.comprobarLogin(ed_email.getEditText().getText().toString(),pass_cifrada);
                if(usuario_existente){
                    Intent intent = new Intent(LoginScreen.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginScreen.this,"El usuario no existe",Toast.LENGTH_LONG).show();
                }

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
}
