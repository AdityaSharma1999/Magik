package com.magik.magikapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText etxt_username;
    private EditText etxt_password;
    private Button btn_login_main;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initElements();
        setListener();
    }

    private void initElements(){
        etxt_username = (EditText) findViewById(R.id.et_username);
        etxt_password = (EditText) findViewById(R.id.et_password);
        btn_login_main = (Button) findViewById(R.id.btn_login_main);
    }

    private void getData(){
        username = etxt_username.getText().toString();
        password = etxt_password.getText().toString();
    }

    private void setListener(){
        btn_login_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
                ParseUser.logInInBackground(username, password, new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if (user != null) {
                            Intent goHome = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(goHome);
                        } else {
                            Toast.makeText(LoginActivity.this, "We had trouble logging in. \n" + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}
