package com.example.glowgenie;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import  androidx.appcompat.app.AppCompatActivity ;
        import  android.os.Bundle ;
        import  android.view.View ;
        import  android.widget.AdapterView ;
        import  android.widget.ArrayAdapter ;
import android.widget.Button;
import android.widget.ImageView;
import  android.widget.Spinner ;
import android.widget.TextView;
import  android.widget.Toast ;

public class Register extends AppCompatActivity implements View.OnClickListener{
    Button Register;
    TextView Signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        Signin = findViewById(R.id.signin);
        Register = findViewById(R.id.register);

        Register.setOnClickListener(this);
        Signin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == Register.getId()){
            Intent intent = new Intent(com.example.glowgenie.Register.this, MainActivity.class);
            startActivity(intent);
        } else if (v.getId() == Signin.getId()) {
            Intent intent = new Intent(com.example.glowgenie.Register.this, LoginForm.class);
            startActivity(intent);
        }
    }
}