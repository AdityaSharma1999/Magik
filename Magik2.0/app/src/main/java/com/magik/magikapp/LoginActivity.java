package com.magik.magikapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText etxt_username;
    private EditText etxt_password;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initElements();
    }

    private void initElements(){
        etxt_username = (EditText) findViewById(R.id.et_username);
        etxt_password = (EditText) findViewById(R.id.et_password);
    }

    private void getData(){
        username = etxt_username.getText().toString();
        password = etxt_password.getText().toString();
    }

    private void setListener(){

    }
}
