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
import android.widget.EditText;
import android.widget.ImageView;
import  android.widget.Spinner ;
import android.widget.TextView;
import  android.widget.Toast ;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity implements View.OnClickListener{
    Button Register;
    FirebaseAuth mAuth;
    TextView Signin;
    EditText nameEditText, emailEditText, passwordEditText, confirmPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        Signin = findViewById(R.id.signin);
        Register = findViewById(R.id.register);
        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);

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

    private void registerUser() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String confirmPassword = confirmPasswordEditText.getText().toString().trim();

        if (password.equals(confirmPassword)) {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, task -> {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            String userEmail = user.getEmail();
                            String userId = user.getUid();
                            Toast.makeText(Register.this, "Registration successful.", Toast.LENGTH_SHORT).show();
                            Log.d("Register", "User ID: " + userId + ", Email: " + userEmail);

                            Intent intent = new Intent(Register.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            String errorMessage = task.getException().getMessage();
                            Toast.makeText(Register.this, "Registration failed: " + errorMessage, Toast.LENGTH_SHORT).show();
                            Log.e("Register", "Registration failed", task.getException());
                        }
                    });
        } else {
            Toast.makeText(Register.this, "Passwords do not match.", Toast.LENGTH_SHORT).show();
        }
    }
}