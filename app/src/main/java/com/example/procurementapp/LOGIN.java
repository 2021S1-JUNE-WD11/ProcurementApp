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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LOGIN extends AppCompatActivity {

    Button signup , signin;
    EditText email, password;

    FirebaseAuth authapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_o_g_i_n);

        authapp = FirebaseAuth.getInstance();

        signup = findViewById(R.id.signuplog);
        signin = findViewById(R.id.Signinlog);
        email = findViewById(R.id.editTextEmailLog);
        password =findViewById(R.id.editTextpass);



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LOGIN.this,Register.class));
            }
        });


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LoginUser();
            }
        });

    }

    private void LoginUser(){
        String userEmail = email.getText().toString();
        String userPass = password.getText().toString();

        if(TextUtils.isEmpty(userEmail)){
            Toast.makeText(this, "Email is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(userPass)) {
            Toast.makeText(this, "password is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        //login user

        authapp.signInWithEmailAndPassword(userEmail,userPass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            Toast.makeText(LOGIN.this, "Login sucessfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LOGIN.this, MainActivity.class));
                        }else{
                            Toast.makeText(LOGIN.this, "Error Login", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}
