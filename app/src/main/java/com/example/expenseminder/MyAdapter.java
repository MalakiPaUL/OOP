package com.example.expenseminder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList id, products, cost,  date;

    public MyAdapter(Context context, ArrayList id, ArrayList products, ArrayList cost, ArrayList date) {
        this.context = context;
        this.id = id;
        this.products = products;
        this.cost = cost;
        this.date = date;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.expenseentry,parent,false);
        return new MyViewHolder(v) ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.id.setText(String.valueOf(id.get(position)));
        holder.products.setText(String.valueOf(products.get(position)));
        holder.cost.setText(String.valueOf(cost.get(position)));
        holder.date.setText(String.valueOf(date.get(position)));
    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id, products,cost,date;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.tId);
            products = itemView.findViewById(R.id.tProducts);
            cost = itemView.findViewById(R.id.tCost);
            date = itemView.findViewById(R.id.tdate);

        }
    }
}
