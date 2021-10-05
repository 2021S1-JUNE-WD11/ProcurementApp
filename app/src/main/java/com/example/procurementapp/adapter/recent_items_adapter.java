package com.example.procurementapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.procurementapp.R;
import com.example.procurementapp.ViewAllActivity;
import com.example.procurementapp.models.Recent_items_model;

import java.util.List;

public class recent_items_adapter extends RecyclerView.Adapter<recent_items_adapter.ViewHolder> {

    private Context context;

    //Create Constructor
    public recent_items_adapter(Context context, List<Recent_items_model> recent_items_models_list) {
        this.context = context;
        this.recent_items_models_list = recent_items_models_list;
    }

    private List<Recent_items_model> recent_items_models_list;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recent_added_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(recent_items_models_list.get(position).getImg_url()).into((holder.rec_img));
        holder.name.setText((recent_items_models_list.get(position).getName()));
        holder.supplier.setText((recent_items_models_list.get(position).getSupplier()));
        holder.price.setText((recent_items_models_list.get(position).getPrice()));
        holder.quantity.setText((recent_items_models_list.get(position).getQuantity()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ViewAllActivity.class);
                intent.putExtra("name",recent_items_models_list.get(position).getName());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return recent_items_models_list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView rec_img;
        TextView name, supplier,price,quantity;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rec_img = itemView.findViewById(R.id.rec_item_img);
            name = itemView.findViewById(R.id.rec_item_name);
            supplier =itemView.findViewById(R.id.rec_sup);
            price = itemView.findViewById(R.id.rec_price);
            quantity = itemView.findViewById(R.id.rec_qty);

        }
    }
}
