package com.PIFF.Homeis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.PIFF.Homeis.entidad.UserDetails;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;

public class ProfileScreen extends AppCompatActivity {
    private TextView usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        usuario = findViewById(R.id.nombreUSR);
        usuario.setText(UserDetails.username);

        //Borde redondo bottom app bar
        float radius = 80;
        BottomAppBar bottomAppBar = findViewById(R.id.bottom_app_bar);

        MaterialShapeDrawable bottomBarBackground = (MaterialShapeDrawable) bottomAppBar.getBackground();
        bottomBarBackground.setShapeAppearanceModel(
                bottomBarBackground.getShapeAppearanceModel()
                        .toBuilder()
                        .setTopRightCorner(CornerFamily.ROUNDED,radius)
                        .setTopLeftCorner(CornerFamily.ROUNDED,radius)
                        .build());
        findViewById(R.id.home_menu_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.chat_menu_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileScreen.this, ChatroomScreen.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.notifi_menu_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileScreen.this, RequestsScreen.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileScreen.this, CreatePost.class);
                startActivity(intent);
            }
        });





    }


}
