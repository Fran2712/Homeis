package com.PIFF.Homeis;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.PIFF.Homeis.entidad.UserDetails;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;
import java.util.Map;


public class ChatScreen extends AppCompatActivity {

    private LinearLayout layout;
    private ImageView sendButton, backButton;
    private EditText messageArea;
    private TextView txt_chatWj;
    private ScrollView scrollView;
    private Firebase reference1, reference2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_screen);


        layout = (LinearLayout) findViewById(R.id.layout1);
        sendButton = (ImageView) findViewById(R.id.sendButton);
        backButton = (ImageView) findViewById(R.id.back_button);
        messageArea = (EditText) findViewById(R.id.messageArea);
        scrollView = (ScrollView) findViewById(R.id.scrollView);

        txt_chatWj = findViewById(R.id.txt_nombre_usr);
        txt_chatWj.setText(UserDetails.chatWith);


        Firebase.setAndroidContext(this);
        reference1 = new Firebase("https://homeis-8b389-default-rtdb.firebaseio.com/mensajes/" + UserDetails.username + "_" + UserDetails.chatWith);
        reference2 = new Firebase("https://homeis-8b389-default-rtdb.firebaseio.com/mensajes/" + UserDetails.chatWith + "_" + UserDetails.username);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageText = messageArea.getText().toString();

                if (!messageText.equals("")) {
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("message", messageText);
                    map.put("user", UserDetails.username);
                    reference1.push().setValue(map);
                    reference2.push().setValue(map);
                    messageArea.setText("");
                }
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        reference1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Map map = dataSnapshot.getValue(Map.class);
                String message = map.get("message").toString();
                String userName = map.get("user").toString();

                if (userName.equals(UserDetails.username)) {
                    addMessageBox(getResources().getString(R.string.msg_tu) + "\n" + message, 1);
                } else {
                    addMessageBox(UserDetails.chatWith + ":\n" + message, 2);
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
    }

    public void addMessageBox(String message, int type) {
        TextView t = new TextView(ChatScreen.this);
        t.setText(message);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 0, 0, 10);
        t.setLayoutParams(lp);

        if (type == 1) {
            t.setTextColor(Color.BLACK);
            t.setBackgroundResource(R.drawable.rounded_corner1);
        } else {
            t.setTextColor(getResources().getColor(R.color.colorAccent7));
            t.setBackgroundResource(R.drawable.rounded_corner2);
        }

        layout.addView(t);
        scrollView.fullScroll(View.FOCUS_DOWN);
    }
}
