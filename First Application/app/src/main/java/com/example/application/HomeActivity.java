package com.example.application;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application.adapter.InternAdapter;
import com.example.application.module.InternItem;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.v("LUMBINI", "onCreate");

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Name from Login ("NAME") or Registration ("fullName")
        String name = getIntent().getStringExtra("NAME");
        if (name == null) {
            name = getIntent().getStringExtra("fullName");
        }
        if (name != null) {
            Toast.makeText(this, "Welcome, " + name, Toast.LENGTH_SHORT).show();
        }

        InternItem[] internItems = {
                new InternItem("UI-UX Intern", "25 Sep, 2026", "UI/UX", "Bharatpur-4, Chitwan", "Bitflux Tech. Solution", "11"),
                new InternItem("Design Intern", "25 Sep, 2026", "UI/UX", "Bharatpur-4, Chitwan", "Bitflux Tech. Solution", "11"),
                new InternItem("QA Intern", "25 Sep, 2026", "UI/UX", "Bharatpur-4, Chitwan", "Bitflux Tech. Solution", "11"),
                new InternItem("Marketing Intern", "25 Sep, 2026", "UI/UX", "Bharatpur-4, Chitwan", "Bitflux Tech. Solution", "11"),
                new InternItem("Sales Intern", "25 Sep, 2026", "UI/UX", "Bharatpur-4, Chitwan", "Bitflux Tech. Solution", "11"),
                new InternItem("Admin Intern", "25 Sep, 2026", "UI/UX", "Bharatpur-4, Chitwan", "Bitflux Tech. Solution", "11"),
                new InternItem("Account Intern", "25 Sep, 2026", "UI/UX", "Bharatpur-4, Chitwan", "Bitflux Tech. Solution", "11"),
                new InternItem("HR Intern", "25 Sep, 2026", "UI/UX", "Bharatpur-4, Chitwan", "Bitflux Tech. Solution", "11")
        };

        InternAdapter internAdapter = new InternAdapter(this, internItems);
        RecyclerView rvIntern = findViewById(R.id.rvIntern);
        rvIntern.setLayoutManager(new LinearLayoutManager(this));
        rvIntern.setAdapter(internAdapter);
    }
}