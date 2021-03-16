package com.PIFF.Homeis;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.PIFF.Homeis.entidad.UserDetails;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;


public class ChatroomScreen extends AppCompatActivity {

    private ListView conversaciones;;
    private TextView noUsersText;
    private ArrayList<String> chats;
    private EditText search_conversations;
    private ImageView search_ic;
    private ProgressDialog pd;
    private int totalUsers = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);

        search_conversations = findViewById(R.id.ET_search_bar);
        search_ic = findViewById(R.id.search_icon);
        chats = new ArrayList<>();


        conversaciones = findViewById(R.id.LV_conversations);
        noUsersText = (TextView)findViewById(R.id.noUsersText);


        // chats
        pd = new ProgressDialog(ChatroomScreen.this);
        pd.setMessage("Loading...");
        pd.show();

        String url = "https://homeis-8b389-default-rtdb.firebaseio.com/mensajes.json";

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>(){
            @Override
            public void onResponse(String s) {
                doOnSuccess(s);
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                System.out.println("" + volleyError);
            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(ChatroomScreen.this);
        rQueue.add(request);

        conversaciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UserDetails.chatWith = chats.get(position);
                startActivity(new Intent(ChatroomScreen.this, ChatScreen.class));
            }
        });


        //Borde Bottom AppBAr
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
                Intent intent = new Intent(ChatroomScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.chat_menu_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChatroomScreen.this, ChatroomScreen.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.notifi_menu_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChatroomScreen.this, RequestsScreen.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChatroomScreen.this, CreatePost.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.profile_menu_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChatroomScreen.this, ProfileScreen.class);
                startActivity(intent);
            }
        });

    }
    public void doOnSuccess(String s){
        try {
            JSONObject obj = new JSONObject(s);

            Iterator i = obj.keys();
            String key = "";

            while(i.hasNext()){
                key = i.next().toString();
                String[] as = key.split("_");

                // pilla las personas  que han tenido mensajes 
                if(!as[0].equals(UserDetails.username)) {
                    if (as[1].equals(UserDetails.username)){
                        chats.add(as[0]);
                    }

                }

                totalUsers++;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(totalUsers <=1){
            noUsersText.setVisibility(View.VISIBLE);
            conversaciones.setVisibility(View.GONE);
        }
        else{
            noUsersText.setVisibility(View.GONE);
            conversaciones.setVisibility(View.VISIBLE);
            conversaciones.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, chats));
        }

        pd.dismiss();
    }

}