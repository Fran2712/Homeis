package com.PIFF.Homeis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.PIFF.Homeis.entidad.Request;

import java.util.ArrayList;
import java.util.Date;

public class RequestsScreen extends AppCompatActivity {

    private RecyclerView request_recycler_services;
    private RecyclerView request_recycler_tools;
    private TextView service_title_btn;
    private TextView tool_title_btn;
    private RecyclerView.LayoutManager gestor;
    private AdaptadorRecyclerRequests adapt_service;
    private AdaptadorRecyclerRequests adapt_tool;
    private ImageView back_btn_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_requests);
        request_recycler_services = findViewById(R.id.rv_service_requests);
        request_recycler_tools = findViewById(R.id.rv_tool_requests);
        service_title_btn = findViewById(R.id.txt_service_btn);
        tool_title_btn = findViewById(R.id.txt_tool_btn);
        back_btn_iv = findViewById(R.id.back_btn_imageview);

        //BTN TO SHOW SERVICE RECYCLER
        service_title_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SET INTENT DIRECTION TO SERVICE REQUESTS SCREEN
                request_recycler_services.setVisibility(View.INVISIBLE);
                request_recycler_tools.setVisibility(View.VISIBLE);
            }
        });

        //BTN TO SHOW TOOLS RECYCLE
        tool_title_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SET INTENT DIRECTION TO SERVICE REQUESTS SCREEN
                request_recycler_tools.setVisibility(View.INVISIBLE);
                request_recycler_services.setVisibility(View.VISIBLE);
            }
        });

        //BTN TO GO BACK
        back_btn_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SET INTENT DIRECTION TO SERVICE REQUESTS SCREEN
                //SET INTENT DIRECTION TO SERVICE REQUESTS SCREEN
                Intent intent = new Intent(RequestsScreen.this, NotificationsScreen.class);
                startActivity(intent);
            }
        });

        //TEST SETTING THE RECYCLER VIEW
        Request r1 = new Request("Chancla Bogan", "IT Assistance", "Could you help me set up this thing called wifi?", new Date());
        Request r2 = new Request("John Prenup", "IT Assistance", "How do I get all my cat pictures into my phone?", new Date());
        ArrayList<Request> service_requests = new ArrayList<>();
        service_requests.add(r1);
        service_requests.add(r2);
        Request r3 = new Request("Marga Sacristan", "21ft Ladder", "I need to borrow the ladder for a few days", new Date());
        Request r4 = new Request("Leo Fanbuca", "Power Drill", "I need the drill to cut holes into my cheese", new Date());
        ArrayList<Request> tool_requests = new ArrayList<>();
        tool_requests.add(r3);
        tool_requests.add(r4);

        gestor = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapt_service = new AdaptadorRecyclerRequests(service_requests);
        //SETTING SERVICE REQUESTS RECYCLER
        request_recycler_services.setAdapter(adapt_service);
        request_recycler_services.setLayoutManager(gestor);

        //SETTING TOOL REQUESTS RECYCLER
        adapt_tool = new AdaptadorRecyclerRequests(tool_requests);
        request_recycler_tools.setAdapter(adapt_tool);
        request_recycler_tools.setLayoutManager(gestor);
    }

}
