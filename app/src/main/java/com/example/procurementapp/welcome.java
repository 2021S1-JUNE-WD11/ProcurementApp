package com.example.procurementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class welcome extends AppCompatActivity {

    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        start =findViewById(R.id.btnstart);



        start.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                startActivity(new Intent(welcome.this,LOGIN.class));
            }
        });
    }
}