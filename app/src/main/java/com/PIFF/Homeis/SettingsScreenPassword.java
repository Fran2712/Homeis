package com.PIFF.Homeis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsScreenPassword extends AppCompatActivity {
    private ImageView img_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_password);
        img_back = findViewById(R.id.btn_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsScreenPassword.this, ProfileScreen.class);
                startActivity(intent);
            }
        });
    }
}