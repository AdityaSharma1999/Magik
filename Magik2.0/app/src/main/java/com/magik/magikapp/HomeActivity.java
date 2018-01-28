package com.magik.magikapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

public class HomeActivity extends AppCompatActivity {

    private Button btn_learn;
    private Button btn_your_health;
    private Button btn_connect;
    private TextView tview_greeting;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        receiveData();
        initElements();
        initListeners();
    }

    private void receiveData(){
        ParseUser currentUser = ParseUser.getCurrentUser();
        name = currentUser.get("name").toString();
    }

    private void initElements(){
        btn_learn = (Button) findViewById(R.id.btn_learn);
        btn_your_health = (Button) findViewById(R.id.btn_your_health);
        btn_connect = (Button) findViewById(R.id.btn_groups);
        tview_greeting = (TextView) findViewById(R.id.tv_home_greeting);
        tview_greeting.setText("Hello " + name + ", how's your day been?");

    }

    private void initListeners(){
        btn_your_health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent yourHealthPage = new Intent(HomeActivity.this, YourHealthActivity.class);
                startActivity(yourHealthPage);
            }
        });
    }
}
