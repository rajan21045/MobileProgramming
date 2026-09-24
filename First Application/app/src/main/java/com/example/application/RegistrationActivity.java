package com.example.application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistrationActivity extends AppCompatActivity {

    Spinner spCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_registration);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> {

                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars()
                    );

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                }
        );

        // City Spinner
        spCity = findViewById(R.id.spCity);

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

        // Registration Button
        Button btnRegistration = findViewById(R.id.btnRegistration);

        btnRegistration.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String selectedCity =
                        spCity.getSelectedItem().toString();

                // Check city selection
                if (selectedCity.equals("Select City")) {

                    Toast.makeText(
                            RegistrationActivity.this,
                            "Please select your city",
                            Toast.LENGTH_SHORT
                    ).show();

                    return;
                }

                // Send city to HomeActivity
                Intent i = new Intent(
                        RegistrationActivity.this,
                        HomeActivity.class
                );

                i.putExtra("city", selectedCity);

                startActivity(i);
            }
        });
    }
}