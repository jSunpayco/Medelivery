package com.mobdeve.s16.group22.medelivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText loginMailET, loginPasswordET;
    Button loginBtn, noAccountBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        this.loginMailET = findViewById(R.id.loginMailET);
        this.loginPasswordET = findViewById(R.id.loginPasswordET);
        this.loginBtn = findViewById(R.id.loginBtn);
        this.noAccountBtn = findViewById(R.id.noAccountBtn);

        this.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = loginMailET.getText().toString().trim();
                String pass = loginPasswordET.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    loginMailET.setError("Please input your email address.");
                    return;
                }

                if(pass.length() < 8){
                    loginPasswordET.setError("Please input your password.");
                    return;
                }

                FirebaseHelper.getFirebaseAuth().signInWithEmailAndPassword(email, pass).
                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            finish();
                        }
                    }
                });
            }
        });

        this.noAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
                finish();
            }
        });

    }
}