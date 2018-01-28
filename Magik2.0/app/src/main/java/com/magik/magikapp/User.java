package com.magik.magikapp;

/**
 * Created by sharm on 1/28/2018.
 */

public class User {
    String firstName="";
    String lastName="";
    int age=0;
    String gender="";
    double height=0.0;
    double weight=0.0;

    public User(String firstName, String lastName, int age, String gender, double height, double weight)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
        this.gender=gender;
        this.height=height;
        this.weight=weight;
    }
}
