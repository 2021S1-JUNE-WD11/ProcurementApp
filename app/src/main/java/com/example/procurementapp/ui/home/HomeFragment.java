package com.example.procurementapp.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.procurementapp.R;
import com.example.procurementapp.adapter.HomeCategoryAdapter;
import com.example.procurementapp.adapter.SuplierAdapter;
import com.example.procurementapp.adapter.recent_items_adapter;
import com.example.procurementapp.models.HomeCategory;
import com.example.procurementapp.models.Recent_items_model;
import com.example.procurementapp.models.SupplierModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView recentitem,home_cat_items,home_supplier_item;
    FirebaseFirestore db;


    List<Recent_items_model>recent_items_modelList;
    recent_items_adapter recent_items_adapter;

    List<HomeCategory> categoryList;
    HomeCategoryAdapter categoryAdapter;

    List<SupplierModel> supplierModels;
    SuplierAdapter suplierAdapter;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        db = FirebaseFirestore.getInstance();

      recentitem = root.findViewById(R.id.recentitem);
        home_cat_items = root.findViewById(R.id.category);
        home_supplier_item =root.findViewById(R.id.suppliers);

      recentitem.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
      recent_items_modelList = new ArrayList<>();
      recent_items_adapter = new recent_items_adapter(getActivity(),recent_items_modelList);
      recentitem.setAdapter(recent_items_adapter);


        db.collection("RecentItems")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Recent_items_model recent_items_model = document.toObject(Recent_items_model.class);
                                recent_items_modelList.add(recent_items_model);

                               recent_items_adapter.notifyDataSetChanged();

                            }
                        } else {
                            Toast.makeText(getActivity(), "Error"+ task.getException(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });



        home_cat_items.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        categoryList = new ArrayList<>();
        categoryAdapter = new HomeCategoryAdapter(getActivity(),categoryList);
        home_cat_items.setAdapter(categoryAdapter);


        db.collection("Category")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                HomeCategory homeCategory = document.toObject(HomeCategory.class);
                               categoryList.add(homeCategory);

                                categoryAdapter.notifyDataSetChanged();

                            }
                        } else {
                            Toast.makeText(getActivity(), "Error"+ task.getException(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });



        home_supplier_item.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        supplierModels = new ArrayList<>();
        suplierAdapter = new SuplierAdapter(getActivity(),supplierModels);
        home_supplier_item.setAdapter(suplierAdapter);


        db.collection("Suppliers")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                SupplierModel supplierModel = document.toObject(SupplierModel.class);
                                supplierModels.add(supplierModel);

                                suplierAdapter.notifyDataSetChanged();

                            }
                        } else {
                            Toast.makeText(getActivity(), "Error"+ task.getException(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
        return root;
    }

}