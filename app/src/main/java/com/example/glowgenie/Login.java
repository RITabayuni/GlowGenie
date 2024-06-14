package com.example.glowgenie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private Button signIn;
    private TextView createAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        signIn = findViewById(R.id.btn_signIn);
        createAccount = findViewById(R.id.create_account);

        signIn.setOnClickListener(this);
        createAccount.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.btn_signIn) {
            Intent I = new Intent(Login.this, LoginForm.class);
            startActivity(I);
        } else if (v.getId() == R.id.create_account) {
            Intent I = new Intent(Login.this, Register.class);
            startActivity(I);
        }
    }
}