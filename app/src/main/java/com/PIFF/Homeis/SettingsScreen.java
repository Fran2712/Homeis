package com.PIFF.Homeis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SettingsScreen extends AppCompatActivity {
    private ImageView img_back, img_name, img_pass, img_add, img_about;
    private TextView logout;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        img_back = findViewById(R.id.btn_back);
        logout = findViewById(R.id.logOut_text);
        firebaseAuth = FirebaseAuth.getInstance();
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user==null){
                    startActivity(new Intent(SettingsScreen.this,LoginScreen.class));
                }
            }
        });
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsScreen.this, ProfileScreen.class);
                startActivity(intent);
            }
        });
        img_name = findViewById(R.id.name_arrow);
        img_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsScreen.this, SettingsScreenName.class);
                startActivity(intent);
            }
        });
        img_pass = findViewById(R.id.password_arrow);
        img_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsScreen.this, SettingsScreenPassword.class);
                startActivity(intent);
            }
        });
        img_add = findViewById(R.id.location_arrow);
        img_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsScreen.this, SettingsScreenDireccion.class);
                startActivity(intent);
            }
        });
        img_about = findViewById(R.id.aboutUs_arrow);
        img_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsScreen.this, AboutUs.class);
                startActivity(intent);
            }
        });



    }
}
