package com.PIFF.Homeis;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


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
        setContentView(R.layout.activity_service_requests);
        rv_conversations = findViewById(R.id.RC_conversations);
        search_conversations = findViewById(R.id.ET_search_bar);
        search_ic = findViewById(R.id.search_icon);

        search_ic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search_subject = String.valueOf(search_conversations.getText());
                //USE 'search_subject' string to SEARCH CONVERSATIONS ARRAY
            }
        });


    }

}