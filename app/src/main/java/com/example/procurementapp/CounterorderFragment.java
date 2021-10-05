package com.example.procurementapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.procurementapp.adapter.CounterAdapter;
import com.example.procurementapp.models.CounterModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.List;


public class CounterorderFragment extends Fragment {

    //declare variables
    FirebaseFirestore db;
    FirebaseAuth auth;
    TextView overTotalAmount;
    RecyclerView recyclerView;
    CounterAdapter counterAdapter;
    List<CounterModel> counterModelList;


    public CounterorderFragment() {
        // Required empty public constructor
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View root= inflater.inflate(R.layout.fragment_counterorder, container, false);

       db = FirebaseFirestore.getInstance();
       auth = FirebaseAuth.getInstance();
       recyclerView = root.findViewById(R.id.recycleview);
       recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
       overTotalAmount = root.findViewById(R.id.text1);

        LocalBroadcastManager.getInstance(getActivity()
        .registerReceiver(mMessageReceiver,new IntentFilter("TotalAmount"));

       counterModelList = new ArrayList<>();
       counterAdapter = new CounterAdapter(getActivity(),counterModelList);
       recyclerView.setAdapter(counterAdapter);

       db.collection("AddCounter").document(auth.getCurrentUser().getUid())
               .collection("currentUser").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
           @Override
           public void onComplete(@NonNull Task<QuerySnapshot> task) {
               if(task.isSuccessful()){

                   for(DocumentSnapshot documentSnapshot :task.getResult().getDocuments()){
                       CounterModel counterModel = documentSnapshot.toObject(CounterModel.class);
                       counterModelList.add(counterModel);
                       counterAdapter.notifyDataSetChanged();
                   }
               }
           }
       });
       return root;
    }
       public BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
           @Override
           public void onReceive(Context context, Intent intent) {

               int totalBill = intent.getIntExtra("totalAmount",0);
               overTotalAmount.setText("Total Bill:" + totalBill+"Rs");

           }
       };

    }
