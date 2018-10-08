package com.example.anphoqua.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anphoqua.MainActivity;
import com.example.anphoqua.model.Animal;
import com.example.anphoqua.sqlite2.R;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<Animal> animals;

    public MyAdapter(Context context, ArrayList<Animal> animals) {
        this.context = context;
        this.animals = animals;
    }

    @Override
    public int getCount() {
        return animals.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
        view = layoutInflater.inflate(R.layout.one_animal, null);
        TextView textView_id = view.findViewById(R.id.OneAnimalIdTextViewID);
        TextView textView_name = view.findViewById(R.id.OneAnimalNameTextViewID);
        TextView textView_age = view.findViewById(R.id.OneAnimalAgeTextViewID);
        ImageView imageView_delete = view.findViewById(R.id.OneAnimalDeleteID);

        final Animal animal = animals.get(i);
        textView_id.setText(animal._id+"");
        textView_name.setText(animal.animal_name);
        textView_age.setText(animal.animal_age+"");

        imageView_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id_delete = animal._id;
                ((MainActivity)context).deleteAnimal(id_delete);
            }
        });
        return view;
    }
}
