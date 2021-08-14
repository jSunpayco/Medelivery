package com.mobdeve.s16.group22.medelivery;

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

public class RegisterActivity extends AppCompatActivity {

    EditText registerFNameET, registerLNameET, registerMailET, registerPasswordET;
    Button registerBtn;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //this.registerFNameET = findViewById(R.id.registerFNameET);
        //this.registerLNameET = findViewById(R.id.registerLNameET);
        this.registerMailET = findViewById(R.id.registerMailET);
        this.registerPasswordET = findViewById(R.id.registerPasswordET);
        this.registerBtn = findViewById(R.id.registerBtn);

        this.fAuth = FirebaseAuth.getInstance();

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
            finish();
        }

        this.registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String fname = registerFNameET.getText().toString().trim();
                //String lname = registerLNameET.getText().toString().trim();
                String email = registerMailET.getText().toString().trim();
                String pass = registerPasswordET.getText().toString().trim();

//                if(TextUtils.isEmpty(fname)){
//                    registerFNameET.setError("Please input your first name.");
//                    return;
//                }

//                if(TextUtils.isEmpty(lname)){
//                    registerFNameET.setError("Please input your surname.");
//                    return;
//                }

                if(TextUtils.isEmpty(email)){
                    registerMailET.setError("Please input your email address.");
                    return;
                }

                if(pass.length() < 8){
                    registerPasswordET.setError("Please input a password with more than 8 characters.");
                    return;
                }

                fAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "User Registered", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                        }else{
                            Toast.makeText(RegisterActivity.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}