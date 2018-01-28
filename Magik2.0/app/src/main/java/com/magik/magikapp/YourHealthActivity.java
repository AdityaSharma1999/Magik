package com.magik.magikapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.appolica.flubber.Flubber;
import com.parse.Parse;
import com.parse.ParseUser;

public class YourHealthActivity extends AppCompatActivity {

    private View fitnessScoreView;
    private String name;
    private int fitnessScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_health);
        getData();
        initElements();
        runAnimation();
    }

    private void runAnimation(){
        Flubber.with()
                .animation(Flubber.AnimationPreset.POP) // Slide up animation
                .repeatCount(1)                              // Repeat once
                .duration(1000)                              // Last for 1000 milliseconds(1 second)
                .createFor(fitnessScoreView)                             // Apply it to the view
                .start();
    }

    private void initElements(){
        fitnessScoreView = fitnessScoreView.findViewById(R.id.tv_fitness_score_fancy);
    }

    private void getData(){
        ParseUser curUser = ParseUser.getCurrentUser();
        name = curUser.get("name").toString();
        fitnessScore = Integer.parseInt(curUser.get("fitness_score").toString());

    }
}
