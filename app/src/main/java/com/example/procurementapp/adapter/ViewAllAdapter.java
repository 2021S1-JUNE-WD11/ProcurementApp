package com.example.procurementapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.procurementapp.R;
import com.example.procurementapp.models.Recent_items_model;
import com.example.procurementapp.models.ViewAllModel;

import java.text.BreakIterator;
import java.util.List;

public class ViewAllAdapter extends RecyclerView.Adapter<ViewAllAdapter.ViewHolder> {



    Context context;
    List<ViewAllModel> list;

    //Create Constructor
    public ViewAllAdapter(Context context, List<ViewAllModel> list) {
        this.context = context;
        this.list = list;
    }






    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_all_products,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAllAdapter.ViewHolder holder, int position) {

        Glide.with(context).load(list.get(position).getImg_url()).into((holder.imageView));
        holder.name.setText((list.get(position).getName()));
        holder.supplier.setText((list.get(position).getSup()));
        holder.price.setText((list.get(position).getPrice()));
        holder.quantity.setText((list.get(position).getQty()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name,price,quantity,supplier;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

         imageView = itemView.findViewById(R.id.allimg);
            name = itemView.findViewById(R.id.itm_name);
            supplier =itemView.findViewById(R.id.itm_sup);
            price = itemView.findViewById(R.id.itm_Price);
            quantity = itemView.findViewById(R.id.itm_qty);
        }
    }
}
