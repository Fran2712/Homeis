package com.PIFF.Homeis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.PIFF.Homeis.adaptadores.AdaptadorRecyclerNotification;
import com.PIFF.Homeis.entidad.Notificacion;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;

import java.util.ArrayList;
import java.util.Date;

public class NotificationsScreen extends AppCompatActivity {

    private ImageView btn_service_requests;
    private RecyclerView rec;
    private TextView service_request_count;
    private RecyclerView.LayoutManager gestor;
    private AdaptadorRecyclerNotification adapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        btn_service_requests = findViewById(R.id.btn_service_request);
        rec = findViewById(R.id.notification_recycler_view);
        service_request_count = findViewById(R.id.service_request_count);

        //SETTING THE SERVICE REQUESTS COUNT
        service_request_count.setText(String.valueOf(getServiceRequestCount()));

        //BTN TO CHECK OUT REQUESTS
        btn_service_requests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SET INTENT DIRECTION TO SERVICE REQUESTS SCREEN
                    Intent intent = new Intent(NotificationsScreen.this, RequestsScreen.class);
                    startActivity(intent);
            }
        });

        //TEST SETTING THE RECYCLER VIEW
        Notificacion n1 = new Notificacion("Chancla Bogan", "This is the coolest subtext", new Date(), "Question reply");
        Notificacion n2 = new Notificacion("Arthur West", "You read, I read, he read", new Date(), "Comment reply");

        ArrayList<Notificacion> salsa = new ArrayList<>();

        salsa.add(n1);
        salsa.add(n2);
        gestor = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapt = new AdaptadorRecyclerNotification(salsa);
        rec.setAdapter(adapt);
        rec.setLayoutManager(gestor);
        // Borde redondo Bottom appbar
        float radius = 80;
        BottomAppBar bottomAppBar = findViewById(R.id.bottom_app_bar);

        MaterialShapeDrawable bottomBarBackground = (MaterialShapeDrawable) bottomAppBar.getBackground();
        bottomBarBackground.setShapeAppearanceModel(
                bottomBarBackground.getShapeAppearanceModel()
                        .toBuilder()
                        .setTopRightCorner(CornerFamily.ROUNDED,radius)
                        .setTopLeftCorner(CornerFamily.ROUNDED,radius)
                        .build());
        //Listeners Bottom app Bar
        findViewById(R.id.home_menu_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotificationsScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.chat_menu_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotificationsScreen.this, ChatroomScreen.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.notifi_menu_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotificationsScreen.this, RequestsScreen.class);
                startActivity(intent);
            }
        });
    }

    public int getServiceRequestCount(){
        int serviceRequestCount = 0;
        //ACCESS FIREBASE DATA BASE AND GET COUNT OF SERVICE + TOOLS REQUESTS
        
        return serviceRequestCount;
    }

}