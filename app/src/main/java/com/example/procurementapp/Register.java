package com.example.procurementapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.procurementapp.models.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    Button signup,signin;
    EditText fname,lname,nic,siteloc,mobno,email,pass;
    FirebaseAuth authapp;
    FirebaseDatabase database;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        authapp = FirebaseAuth.getInstance();

        database = FirebaseDatabase.getInstance();

        signup = findViewById(R.id.btnRsignUp);
        signin = findViewById(R.id.SigninReg);
        fname = findViewById(R.id.editTextfname);
        lname = findViewById(R.id.editTextlname);
        nic = findViewById(R.id.editTextnic);
        siteloc = findViewById(R.id.editTextnic);
        mobno = findViewById(R.id.editTextmobile);
        email = findViewById(R.id.editTextTextEmail);
        pass = findViewById(R.id.editTextpassReg);


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this, LOGIN.class));
            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });

    }
    private void createUser(){

        String userFname = fname.getText().toString();
        String userlname = lname.getText().toString();
        String userNic = nic.getText().toString();
        String userSiteloc = siteloc.getText().toString();
        String userMobno = mobno.getText().toString();
        String userEmail = email.getText().toString();
        String userPass = pass.getText().toString();

        if(TextUtils.isEmpty(userFname)){
            Toast.makeText(this, "Firstname is empty", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(userlname)){
            Toast.makeText(this, "lastname is empty", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(userNic)){
            Toast.makeText(this, "NIC is empty", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(userSiteloc)){
            Toast.makeText(this, "Sitelocation is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(userMobno)){
            Toast.makeText(this, "Mobile is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(userEmail)){
            Toast.makeText(this, "Email is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(userPass)){
            Toast.makeText(this, "password is empty", Toast.LENGTH_SHORT).show();
            return;
        }

        authapp.createUserWithEmailAndPassword(userEmail,userPass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            UserModel userModel = new UserModel(userFname,userlname,userNic,userSiteloc,userMobno,userEmail,userPass);
                            String id = task.getResult().getUser().getUid();
                            database.getReference().child("Users").child(id).setValue(userModel);


                            Toast.makeText(Register.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                        } else {

                            Toast.makeText(Register.this, "Error" , Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

}
