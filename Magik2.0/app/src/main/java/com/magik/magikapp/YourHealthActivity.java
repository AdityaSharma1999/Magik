package com.magik.magikapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.appolica.flubber.Flubber;
import com.parse.Parse;
import com.parse.ParseUser;

import org.w3c.dom.Text;

public class YourHealthActivity extends AppCompatActivity {

    private TextView fitnessScoreView;
    private String name;
    private TextView tview_myHealthSummary;
    private String fitnessScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_health);
        getData();
        initElements();
        displayData();
        runAnimation();
    }

    private void runAnimation(){
        Flubber.with()
                .animation(Flubber.AnimationPreset.SLIDE_UP) // Slide up animation
                .repeatCount(1)                              // Repeat once
                .duration(1000)                              // Last for 1000 milliseconds(1 second)
                .createFor(fitnessScoreView)                             // Apply it to the view
                .start();
    }

    private void initElements(){
        fitnessScoreView =  (TextView) findViewById(R.id.tv_fitness_score_fancy);
        tview_myHealthSummary = (TextView) findViewById(R.id.tv_greeting_health);
    }

    private void getData(){
        ParseUser curUser = ParseUser.getCurrentUser();
        name = curUser.get("name").toString();
        fitnessScore = curUser.get("fitness_score").toString();
    }

    private void displayData(){
        tview_myHealthSummary.setText("Hello " + name + ", your current fitness score is");
        fitnessScoreView.setText(fitnessScore);
    }
}
