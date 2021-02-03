package com.PIFF.Homeis;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    //Variables
    Animation myanim;
    Animation myanim2;
    Animation myanim3;
    ImageView logo;
    ImageView yellowDoor;
    ImageView greenDoor;
    TextView appName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Status Bar off
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splash_screen);

        openApp(true);

        //Implement
        logo = findViewById(R.id.homeis_logo);
        appName = findViewById(R.id.textView_app_name);
        yellowDoor = findViewById(R.id.yellowDoor);
        greenDoor = findViewById(R.id.greenDoor);

        //Animations

            //Fadein Logo
        myanim = AnimationUtils.loadAnimation(this, R.anim.fadein);
        logo.startAnimation(myanim);
            //Fadein NombreApp
        myanim = AnimationUtils.loadAnimation(this, R.anim.fadein);
        appName.startAnimation(myanim);

        //Leftin Puerta amarilla
        myanim2 = AnimationUtils.loadAnimation(this, R.anim.leftin);
        yellowDoor.startAnimation(myanim2);
        //Rightin Puerta verde
        myanim3 = AnimationUtils.loadAnimation(this, R.anim.rightin);
        greenDoor.startAnimation(myanim3);

    }

    private void openApp(boolean locationPermission) {

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen
                        .this, MainActivity.class);
                startActivity(intent);
            }
        }, 5000);
    }
}
