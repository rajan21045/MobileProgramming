package com.example.application;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());

            v.setPadding(
                    systemBars.left,
                    systemBars.top,
                    systemBars.right,
                    systemBars.bottom
            );

            return insets;
        });

        ListView listView = findViewById(R.id.listView);

        String[] internships = {
                "Android Developer Intern\nTech Solutions - Kathmandu",
                "Flutter Developer Intern\nABC Software - Lalitpur",
                "Java Developer Intern\nCode Nepal - Kathmandu",
                "Web Developer Intern\nDigital Nepal - Remote",
                "Python Developer Intern\nInnovate Tech - Pokhara"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                internships
        );

        listView.setAdapter(adapter);
    }

}