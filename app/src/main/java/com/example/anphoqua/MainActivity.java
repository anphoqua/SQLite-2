package com.example.anphoqua;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.anphoqua.Adapter.MyAdapter;
import com.example.anphoqua.SQLite.AnimalDAO;
import com.example.anphoqua.model.Animal;
import com.example.anphoqua.sqlite2.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button add_button;
    ListView animal_listView;
    AnimalDAO animalDAO;
    ArrayList<Animal> animalArrayList = new ArrayList<Animal>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_button = findViewById(R.id.AddAnimalButtonID);
        animal_listView = findViewById(R.id.AnimalListViewID);
        animalDAO = new AnimalDAO(MainActivity.this);

       updateListView();


        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater layoutInflater = getLayoutInflater();
                final View v = layoutInflater.inflate(R.layout.dialog_add_edit, null);
                alertDialog.setView(v);

                alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText animal_name = v.findViewById(R.id.AnimalNameEditTextID);
                        EditText animal_age = v.findViewById(R.id.AnimalAgeEditTextID);

                        Animal animal = new Animal(animal_name.getText().toString(), Integer.parseInt(animal_age.getText().toString()));
                        animalDAO.addAnimal(animal);

                        updateListView();
                    }
                });

                alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });


                alertDialog.show();
            }
        });
    }

    public void updateListView(){
        animalArrayList = animalDAO.getAnimal();
        MyAdapter myAdapter = new MyAdapter(MainActivity.this, animalArrayList);
        animal_listView.setAdapter(myAdapter);
    }

    public void deleteAnimal(int _id){
        animalDAO.deleteAnimal(_id);
        updateListView();

    }
}
