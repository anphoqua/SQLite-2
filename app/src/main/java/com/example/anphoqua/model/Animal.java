package com.example.anphoqua.model;

public class Animal {
    public int _id;
    public String animal_name;
    public int animal_age;

    public Animal(){}

    public Animal(int _id, String animal_name, int animal_age) {
        this._id = _id;
        this.animal_name = animal_name;
        this.animal_age = animal_age;
    }

    public Animal(String animal_name, int animal_age) {
        this.animal_name = animal_name;
        this.animal_age = animal_age;
    }

}
