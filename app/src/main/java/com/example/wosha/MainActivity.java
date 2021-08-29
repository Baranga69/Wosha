package com.example.wosha;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),log_in.class));
        finish();
    }

    public void create(View view){
        startActivity(new Intent(getApplicationContext(), createOrder.class));
        finish();
    }

    public void pushSeeker(View view){
        startActivity(new Intent(getApplicationContext(), Seeker.class));
        finish();
    }

}