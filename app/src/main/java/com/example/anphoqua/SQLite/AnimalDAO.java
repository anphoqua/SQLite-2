package com.example.anphoqua.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.anphoqua.model.Animal;

import java.util.ArrayList;

public class AnimalDAO {
    SQLiteDatabase sqLiteDatabase;
    MyDBHelper myDBHelper;

    Context context;

    public AnimalDAO (Context context) {
        this.context = context;
        myDBHelper = new  MyDBHelper(context);
    }

    public void addAnimal(Animal animal)
    {
        sqLiteDatabase = myDBHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", animal.animal_name);
        values.put("age", animal.animal_age);
        sqLiteDatabase.insert("animals", null, values);
    }

    public ArrayList<Animal> getAnimal() {
        ArrayList<Animal> animalArrayList = new ArrayList<Animal>();
        sqLiteDatabase = myDBHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from animals", null);

        if (cursor.moveToFirst()) {
            do {
                int _id = cursor.getInt(0);
                String name = cursor.getString(1);
                int age = cursor.getInt(2);
                Animal animal = new Animal(_id, name, age);
                animalArrayList.add(animal);
            } while (cursor.moveToNext());
        }
        return animalArrayList;
    }

    public Animal getOneAnimal(int _id) {
        sqLiteDatabase = myDBHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from animals where _id=?", new String[]{_id+""});
        cursor.moveToFirst();
        int id = cursor.getInt(0);
        String name = cursor.getString(1);
        int age = cursor.getInt(2);
        Animal animal = new Animal(id, name, age);
        return animal;
    }

    public void deleteAnimal(int _id){
        sqLiteDatabase = myDBHelper.getWritableDatabase();
        sqLiteDatabase.delete("animals", "_id=?", new String[]{_id+""});

    }
}
