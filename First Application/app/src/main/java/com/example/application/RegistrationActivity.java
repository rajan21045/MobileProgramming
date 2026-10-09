
package com.example.application;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistrationActivity extends AppCompatActivity {

    private EditText etFullName, etEmail;
    private EditText etPassword, etConfirmPassword;
    private RadioGroup radiogp1;
    private Spinner spCity;
    private Button btnRegistration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (view, insets) -> {
                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars()
                    );

                    view.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                }
        );

        // Initialize views
        etFullName = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);

        radiogp1 = findViewById(R.id.radiogp1);
        spCity = findViewById(R.id.spCity);
        btnRegistration = findViewById(R.id.btnRegistration);

        // Set up City Spinner
        String[] cities = {
                "Select City",
                "Kathmandu",
                "Pokhara",
                "Bharatpur",
                "Butwal",
                "Lalitpur",
                "Biratnagar",
                "Birgunj"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                cities
        );

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spCity.setAdapter(adapter);

        // Register button click
        btnRegistration.setOnClickListener(view -> registerUser());
    }

    private void registerUser() {

        String fullName = etFullName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString();
        String confirmPassword =
                etConfirmPassword.getText().toString();

        // Validate full name
        if (fullName.isEmpty()) {
            etFullName.setError("Please enter your full name");
            etFullName.requestFocus();
            return;
        }

        // Validate email
        if (email.isEmpty()) {
            etEmail.setError("Please enter your email");
            etEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Enter a valid email address");
            etEmail.requestFocus();
            return;
        }

        // Validate gender
        int selectedGenderId = radiogp1.getCheckedRadioButtonId();

        if (selectedGenderId == -1) {
            Toast.makeText(
                    this,
                    "Please select your gender",
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }

        RadioButton selectedGender =
                findViewById(selectedGenderId);

        String gender = selectedGender.getText().toString();

        // Validate city
        String city = spCity.getSelectedItem().toString();

        if (city.equals("Select City")) {
            Toast.makeText(
                    this,
                    "Please select your city",
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }

        // Validate password
        if (password.isEmpty()) {
            etPassword.setError("Please enter a password");
            etPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            etPassword.setError(
                    "Password must contain at least 6 characters"
            );
            etPassword.requestFocus();
            return;
        }

        // Validate confirm password
        if (confirmPassword.isEmpty()) {
            etConfirmPassword.setError(
                    "Please confirm your password"
            );
            etConfirmPassword.requestFocus();
            return;
        }

        if (!password.equals(confirmPassword)) {
            etConfirmPassword.setError(
                    "Passwords do not match"
            );
            etConfirmPassword.requestFocus();
            return;
        }

        // All validations passed
        Toast.makeText(
                this,
                "Registration successful!",
                Toast.LENGTH_SHORT
        ).show();

        // Navigate to HomeActivity
        Intent intent = new Intent(
                RegistrationActivity.this,
                HomeActivity.class
        );

        intent.putExtra("fullName", fullName);
        intent.putExtra("email", email);
        intent.putExtra("gender", gender);
        intent.putExtra("city", city);

        startActivity(intent);
    }
}