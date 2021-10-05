package com.example.procurementapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.procurementapp.R;
import com.example.procurementapp.models.CounterModel;
import com.example.procurementapp.models.ViewAllModel;

import java.util.List;

public class CounterAdapter  extends RecyclerView.Adapter<CounterAdapter.ViewHolder> {

    //declare variables
    Context context;
    List<CounterModel> list;
    int totalprice = 0;


    //Create constructor
    public CounterAdapter(Context context, List<CounterAdapter> list) {
        this.context = context;
        this.list = list;
    }



    public CounterAdapter() {

    }

    @NonNull
    @Override
    public CounterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.counterItem,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CounterAdapter.ViewHolder holder, int position) {

        holder.name.setText((list.get(position).getProductName()));
        holder.supplier.setText((list.get(position).getSuplierName()));
        holder.totalprice.setText((list.get(position).getProductPrice()));
        holder.quantity.setText((list.get(position).getTotalqty()));
        holder.date.setText((list.get(position).getCurrentDate()));
        holder.time.setText((list.get(position).getCurrentTime()));

        //pass total amount to Counter fragment

        totalprice = totalprice + list.get(position).getTotalPrice();
        Intent intent = new Intent("TotalAmount");
        intent.putExtra("totalAmount",totalprice);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, supplier,totalprice,quantity,date,time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            name = itemView.findViewById(R.id.product_name);
            supplier =itemView.findViewById(R.id.product_sup);
            totalprice = itemView.findViewById(R.id.product_totalPrice);
            quantity = itemView.findViewById(R.id.product_totalqty);
            date = itemView.findViewById(R.id.currentdate);
            time = itemView.findViewById(R.id.currentTime);
        }
    }
}
