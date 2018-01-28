package com.magik.magikapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    private EditText etxt_name;
    private EditText etxt_email;
    private EditText etxt_username;
    private EditText etxt_password;
    private EditText etxt_age;
    private EditText etxt_person_gender;
    private EditText etxt_height;
    private EditText etxt_weight;
    private Button btn_signup_confirm;
    private String name;
    private String email;
    private String username;
    private String password;
    private int age;
    private String gender;
    private double height;
    private double weight;
    private Spinner spinboiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initElements();
        setListner();
    }

    private void initElements(){
        etxt_name = (EditText) findViewById(R.id.et_person_name);
        etxt_email = (EditText) findViewById(R.id.et_person_email);
        etxt_username = (EditText) findViewById(R.id.et_person_username);
        etxt_password = (EditText) findViewById(R.id.et_person_password);
        etxt_age = (EditText) findViewById(R.id.et_person_age);
        spinboiz=(Spinner) findViewById(R.id.spinner);
        //etxt_person_gender = (EditText) findViewById(R.id.et_person_gender);
        etxt_height = (EditText) findViewById(R.id.et_person_height);
        etxt_weight = (EditText) findViewById(R.id.et_person_weight);
        btn_signup_confirm = (Button) findViewById(R.id.btn_signup_confirm);


    }

    private void getData(){
        name = etxt_name.getText().toString();
        email = etxt_email.getText().toString();
        username = etxt_username.getText().toString();
        password = etxt_password.getText().toString();
        age = Integer.parseInt(etxt_age.getText().toString());
        gender = spinboiz.getSelectedItem().toString();//etxt_person_gender.getText().toString();
        height = Double.parseDouble(etxt_height.getText().toString());
        weight = Double.parseDouble(etxt_weight.getText().toString());

    }

    private void setListner(){
        btn_signup_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    attemptRegister();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void attemptRegister(){
        getData();
        ParseUser newUser = new ParseUser();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);
        newUser.put("name", name);
        newUser.put("age", age);
        newUser.put("gender", gender);
        newUser.put("height", height);
        newUser.put("weight", weight);
        newUser.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null){
                    Toast.makeText(SignUpActivity.this, "Welcome to Magik Health!", Toast.LENGTH_LONG).show();
                    Intent goBackToMain = new Intent(SignUpActivity.this, MainActivity.class);
                    startActivity(goBackToMain);

                } else {
                    Toast.makeText(SignUpActivity.this, "There was a problem connecting to the server. \n" + e.getMessage(), Toast.LENGTH_LONG ).show();
                }
            }
        });
    }
}
