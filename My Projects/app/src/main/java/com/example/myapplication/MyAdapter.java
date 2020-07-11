package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter {

        ArrayList<pokemon> yArray ;
        Context c;

    public MyAdapter(ArrayList<pokemon> yArray, Context c) {
        this.yArray = yArray;
        this.c = c;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View x = LayoutInflater.from(parent.getContext()).inflate(R.layout.xml2,parent,false);
        ViewHolder ax = new ViewHolder(x);
        return ax;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ((ViewHolder) holder).img.setImageResource(yArray.get(position).getImage());
        ((ViewHolder) holder).pokemonName.setText(yArray.get(position).getName());
        ((ViewHolder) holder).total.setText(yArray.get(position).getTotal()+"");
        ((ViewHolder)holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(c,MainActivity2.class);
                i.putExtra("pokemon",yArray.get(position));
                c.startActivity(i);
            }
        });

        ((ViewHolder)holder).delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yArray.remove(position);
                 notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return yArray.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder{
         public ImageView img;
        public ImageView delete;
         public TextView pokemonName;
         public TextView total;
         public View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            pokemonName = itemView.findViewById(R.id.textView);
            total = itemView.findViewById(R.id.textView3);
            img = itemView.findViewById(R.id.imageView);
            delete = itemView.findViewById(R.id.imageView2);
        }
    }
}
