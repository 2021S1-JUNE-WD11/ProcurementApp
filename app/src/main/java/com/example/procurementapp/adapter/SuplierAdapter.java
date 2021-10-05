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
import com.example.procurementapp.models.SupplierModel;

import java.util.List;

public class SuplierAdapter extends RecyclerView.Adapter<SuplierAdapter.ViewHolder> {

    Context context;

    //Create constructor
    public SuplierAdapter(Context context, List<SupplierModel> list) {
        this.context = context;
        this.list = list;
    }

    List<SupplierModel> list;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_supplier_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SuplierAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getImg_url()).into(holder.imageView);
        holder.id.setText(list.get(position).getSup_id());
        holder.name.setText(list.get(position).getSup_name());
        holder.loc.setText(list.get(position).getSup_location());
        holder.mob.setText(list.get(position).getSup_mob());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView id,name,loc,mob;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.sup_item_img);
            id = itemView.findViewById(R.id.supid);
            name =itemView.findViewById(R.id.Sup_name);
            loc = itemView.findViewById(R.id.Sup_loc);
            mob = itemView.findViewById(R.id.sup_mob);

        }
    }
}
