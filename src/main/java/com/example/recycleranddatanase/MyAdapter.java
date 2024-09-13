package com.example.recycleranddatanase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    //create variable for recycler view
    private Context context;
    private ArrayList name_id,email_id,age_id;

    //constructor
    public MyAdapter(Context context, ArrayList name_id, ArrayList email_id, ArrayList age_id) {
        //initialize variable
        this.context = context;
        this.name_id = name_id;
        this.email_id = email_id;
        this.age_id = age_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //inflate the layout
        View v= LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        //set data to text view
        holder.name_id.setText(String.valueOf(name_id.get(position)));
        holder.email_id.setText(String.valueOf(email_id.get(position)));
        holder.age_id.setText(String.valueOf(age_id.get(position)));

    }

    @Override
    public int getItemCount() {
        //return size of recycler view
        return name_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //create variable for text view
        TextView name_id,email_id,age_id;
        //create view holder
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //find id of layout which showed in recycler view
            name_id=itemView.findViewById(R.id.name);
            email_id=itemView.findViewById(R.id.email);
            age_id=itemView.findViewById(R.id.age);
        }
    }
}
