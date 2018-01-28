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
    private String person_object_ID;
    private double fitness_score;

    public User(String name, String email, String username, String password, int age, String gender, double height, double weight)
    {
        person_name= name;
        person_email = email;
        person_username = username;
        person_password = password;
        person_age =age;
        person_gender = gender;
        person_height=height;
        person_weight=weight;
        fitness_score = 100;
    }

    public Double calculateFitnessScore(Boolean improvedFitness){
        if (improvedFitness == true){
            fitness_score = fitness_score + 20;
        } else {
            fitness_score = fitness_score - 10;
        }
        return fitness_score;
    }

    public void setPersonName(String name){
        person_name = name;
    }

    public String getPersonName(){
        return person_name;
    }

    public void setPersonAge(int age){
        person_age = age;
    }

    public int getPersonAge(){
        return person_age;
    }
    public void setPersonGender(String gender){
        person_gender = gender;
    }

    public String getPersonGender(){
        return person_gender;
    }

    public void setPersonHeight(Double height){
        person_height = height;
    }

    public Double getPersonHeight(){
        return person_height;
    }

    public void setPersonWeight(Double weight){
        person_weight = weight;
    }

    public Double getPersonWeight(){
        return person_weight;
    }

    public void setPersonEmail(String email){
        person_email = email;
    }

    public String getPersonEmail(){
        return person_email;
    }

    public void setPassword(String password){
        person_password = password;
    }

    public String getPassword() {
        return person_password;
    }

    public void setUsername(String username){
        person_username = username;
    }

    public String getUsername(){
        return person_username;
    }

    public void setUserObjectID(String objectID){
        person_object_ID = objectID;
    }

    public double getFitness_score(){
        return fitness_score;
    }



}
