package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<pokemon> myPokemons = new ArrayList<>();

        pokemon n1 = new pokemon("ivysaur",R.drawable.ivysaur,62,63,405);
        pokemon n2 = new pokemon("pikachu",R.drawable.pikachu,55,40,320);
        pokemon n3 = new pokemon("Gengar",R.drawable.gengar,65,60,500);
        pokemon n4 = new pokemon("Charizard",R.drawable.charizard,84,78,534);
        pokemon n5 = new pokemon("Blastoise",R.drawable.blastoise,83,100,530);

        myPokemons.add(n1);
        myPokemons.add(n2);
        myPokemons.add(n3);
        myPokemons.add(n4);
        myPokemons.add(n5);

        RecyclerView z = findViewById(R.id.rv1);

         z.setHasFixedSize(true);
         RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
         z.setLayoutManager(lm);

        MyAdapter adapter = new MyAdapter(myPokemons,this);
        z.setAdapter(adapter);
         

                 




    }
}