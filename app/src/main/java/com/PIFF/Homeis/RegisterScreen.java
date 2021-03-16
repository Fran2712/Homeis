package com.PIFF.Homeis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.PIFF.Homeis.cifrado.ResumenHash;
import com.PIFF.Homeis.entidad.Usuario;
import com.PIFF.Homeis.persistencia.AccesoFirebase;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterScreen extends AppCompatActivity {

    private Button btn_register;
    private TextInputLayout ed_email;
    private TextInputLayout ed_pass;
    private TextInputLayout ed_conf_pass;
    private MaterialCheckBox cb_terms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);
        ed_email =(TextInputLayout) findViewById(R.id.ED_email);
        ed_pass = (TextInputLayout)findViewById(R.id.ED_pass);
        ed_conf_pass = (TextInputLayout)findViewById(R.id.ED_conf_pass);
        cb_terms = findViewById(R.id.CB_terms);
        btn_register = findViewById(R.id.BTN_regster);
        ed_email.getEditText().addTextChangedListener(validarCampos);
        ed_pass.getEditText().addTextChangedListener(validarCampos);
        ed_conf_pass.getEditText().addTextChangedListener(validarCampos);
        cb_terms.setOnCheckedChangeListener(validarCheckBox);

        btn_register.setEnabled(false);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario user = new Usuario(ed_email.getEditText().getText().toString(),ed_pass.getEditText().getText().toString());
                List<Usuario> usuariosBBDD= AccesoFirebase.devolverUsuarios();
                boolean usuario_existente = AccesoFirebase.comprobarUsuario(ed_email.getEditText().getText().toString());
                if (usuario_existente || usuariosBBDD.isEmpty()){
                    Toast.makeText(RegisterScreen.this,"El usuario ya existe",Toast.LENGTH_LONG).show();
                }else{
                    String pass_cifrada= ResumenHash.cifrarPassword(user.getPassword());
                    user.setPassword(pass_cifrada);
                    AccesoFirebase.altaUsuario(user);
                    Intent intent = new Intent(RegisterScreen.this, DireccionScreen.class);
                    intent.putExtra("usuario",user);

                    startActivity(intent);
                }
            }
        });
    }
    public boolean comprobarCampos(String email, String pass, String conf_pass, boolean terms){
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
        }else if(!pass.equals(conf_pass)){
            ed_conf_pass.getEditText().setError("Las contraseñas no coinciden");
            return false;
        }else if(conf_pass.isEmpty()){
            ed_conf_pass.getEditText().setError("Campo vacio!");
            if(!pass.equals(conf_pass)){
                ed_conf_pass.getEditText().setError("Las contraseñas no coinciden");
            }
            return false;
        }else if(pass.isEmpty()){
            ed_pass.getEditText().setError("Campo vacio!");
            return false;
        }else if(terms == false){
            return false;
        }else{
            return true;
        }
    }
    private TextWatcher validarCampos = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String email=ed_email.getEditText().getText().toString();
            String pass= ed_pass.getEditText().getText().toString();
            String conf_pass = ed_conf_pass.getEditText().getText().toString();
            boolean terms = cb_terms.isChecked();
            btn_register.setEnabled(comprobarCampos(email,pass,conf_pass,terms));
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    private CompoundButton.OnCheckedChangeListener validarCheckBox  = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            String email=ed_email.getEditText().getText().toString();
            String pass= ed_pass.getEditText().getText().toString();
            String conf_pass = ed_conf_pass.getEditText().getText().toString();
            boolean terms = cb_terms.isChecked();
            btn_register.setEnabled(comprobarCampos(email,pass,conf_pass,terms));
        }
    };
}