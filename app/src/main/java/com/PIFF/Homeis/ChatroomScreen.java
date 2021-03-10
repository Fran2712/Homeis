package com.PIFF.Homeis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;


public class ChatroomScreen extends AppCompatActivity {

    private RecyclerView rv_conversations;
    private EditText search_conversations;
    private ImageView search_ic;
    private RecyclerView.LayoutManager gestor;
    //CREAR ENTIDAD Conversation.
    //CREAR ADAPTADOR AdaptadorRecyclerConversations
    //private AdaptadorRecyclerConversations adapt_conversations;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);
        rv_conversations = findViewById(R.id.RC_conversations);
        search_conversations = findViewById(R.id.ET_search_bar);
        search_ic = findViewById(R.id.search_icon);



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


    }

}