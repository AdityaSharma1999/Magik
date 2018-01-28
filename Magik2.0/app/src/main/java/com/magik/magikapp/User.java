package com.magik.magikapp;

/**
 * Created by sharm on 1/28/2018.
 */

public class User {

    private String person_name;
    private int person_age;
    private String person_gender;
    private double person_height;
    private double person_weight;
    private String person_email;
    private String person_username;
    private String person_password;

    public User(String name, String email, String username, String password, int age, String gender, double height, double weight)
    {
        person_name= name;
        person_age =age;
        person_gender = gender;
        person_height=height;
        person_weight=weight;
    }
}
