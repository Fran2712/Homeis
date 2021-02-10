package com.PIFF.Homeis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterScreen extends AppCompatActivity {

    private Button btn_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);
        btn_register = findViewById(R.id.BTN_regster);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent = new Intent(RegisterScreen.this, MainActivity.class);
               // startActivity(intent);
            }
        });
    }
}