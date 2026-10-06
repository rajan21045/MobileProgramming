package com.example.application;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application.module.InternItem;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_home);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> {

                    Insets systemBars =
                            insets.getInsets(
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

        // Internship data
        InternItem[] internItems = {

                new InternItem(
                        "UI/UX Intern",
                        "25 Sep, 2026",
                        "UI/UX",
                        "Bharatpur-07, Chitwan",
                        "ABC Company"
                ),

                new InternItem(
                        "Android Developer Intern",
                        "26 Sep, 2026",
                        "Android Development",
                        "Bharatpur-10, Chitwan",
                        "XYZ Technologies"
                ),

                new InternItem(
                        "Flutter Intern",
                        "27 Sep, 2026",
                        "Flutter Development",
                        "Kathmandu",
                        "Tech Solutions"
                ),

                new InternItem(
                        "Web Developer Intern",
                        "28 Sep, 2026",
                        "Web Development",
                        "Pokhara",
                        "Web Nepal"
                ),

                new InternItem(
                        "Graphic Designer Intern",
                        "29 Sep, 2026",
                        "Graphic Design",
                        "Bharatpur-07, Chitwan",
                        "Creative Studio"
                ),

                new InternItem(
                        "Java Developer Intern",
                        "30 Sep, 2026",
                        "Java Development",
                        "Kathmandu",
                        "Java Solutions"
                )
        };

        // Find RecyclerView
        RecyclerView rvInterns = findViewById(R.id.rvInterns);

        // Set layout manager
        rvInterns.setLayoutManager(
                new LinearLayoutManager(this)
        );

        // Create adapter
        InternAdapter internAdapter =
                new InternAdapter(this, internItems);

        // Attach adapter
        rvInterns.setAdapter(internAdapter);
    }

}
