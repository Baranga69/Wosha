package com.example.wosha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class log_in extends AppCompatActivity {
    TextInputEditText mEmail,mPassword;
    Button mLogInBtn;
    TextView mSignUpBtn;
    ProgressBar progressBar2;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

        mEmail = findViewById(R.id.email2);
        mPassword = findViewById(R.id.password2);
        progressBar2 = findViewById(R.id.progressBar2);
        fAuth = FirebaseAuth.getInstance();
        mLogInBtn = findViewById(R.id.logInBtn);
        mSignUpBtn = findViewById(R.id.createrBtn);

        mLogInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is required");
                    return;
                }
                if(password.length()< 6){
                    mPassword.setError("Password must be >= 6 characters");
                    return;
                }
                progressBar2.setVisibility(View.VISIBLE);

                //Authenticating the user
                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                     if(task.isSuccessful()){
                         Toast.makeText(log_in.this, "Successfully logged in", Toast.LENGTH_SHORT).show();
                         startActivity(new Intent(getApplicationContext(),MainActivity.class));
                     }else{
                         Toast.makeText(log_in.this, "Error! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                     }
                    }
                });
                clearFields();
            }
        });

        mSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),sign_up.class));
            }
        });


    }

    public void clearFields(){
        mEmail.getText().clear();
        mPassword.getText().clear();
    }
}