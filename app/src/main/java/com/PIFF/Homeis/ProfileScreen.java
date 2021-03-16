package com.PIFF.Homeis;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ProfileScreen extends FragmentActivity implements OnMapReadyCallback {
    private LocationManager lc = null;
    private GoogleMap mMap;
    private ImageView img_settings;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        lc = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        //Listeners Bottom app Bar
        findViewById(R.id.first_menu_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.second_menu_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileScreen.this, ChatroomScreen.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.third_menu_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileScreen.this, NotificationsScreen.class);
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
        findViewById(R.id.fourth_menu_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileScreen.this, ProfileScreen.class);
                startActivity(intent);
            }
        });
        img_settings = findViewById(R.id.settings_iv);
        img_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileScreen.this, SettingsScreen.class);
                startActivity(intent);
            }
        });
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void chequearPermisos() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            String[] permisos = {Manifest.permission.ACCESS_FINE_LOCATION};
            requestPermissions(permisos,666);
            return;
        }
        else{
            obtenerUbicacion();
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void obtenerUbicacion() {
        LocationListener oyente_localizaciones = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                Log.d("localizacion: ", location.getLatitude() + "," + location.getLongitude());
                //lc.removeUpdates(this);
                LatLng ubicacion = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.addMarker(new MarkerOptions().position(ubicacion).title("Mi ubicacion"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacion));
            }
        };
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        lc.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10, 0, oyente_localizaciones);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        chequearPermisos();

    }
}


