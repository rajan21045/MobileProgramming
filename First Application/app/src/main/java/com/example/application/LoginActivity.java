package com.example.application;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

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

        Button btLogin = findViewById(R.id.btLogin);
        EditText etUserName = findViewById(R.id.etUserName);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btRegister = findViewById(R.id.btRegister);

        btLogin.setOnClickListener(view -> {
            String name = etUserName.getText().toString().trim();
            String password = etPassword.getText().toString();

            if (name.isEmpty()) {
                etUserName.setError("Please enter your username");
                etUserName.requestFocus();
                return;
            }

            if (password.isEmpty()) {
                etPassword.setError("Please enter your password");
                etPassword.requestFocus();
                return;
            }

            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
            i.putExtra("NAME", name);
            startActivity(i);
            finish();
        });

        btRegister.setOnClickListener(view ->
                startActivity(new Intent(LoginActivity.this, RegistrationActivity.class)));
    }
}