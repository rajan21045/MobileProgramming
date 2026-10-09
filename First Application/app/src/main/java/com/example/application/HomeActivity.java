package com.example.application;

import android.os.Bundle;
import android.util.Log;

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

        InternItem[] internItems = {
                new InternItem("UI-UX Intern","25 Sep, 2026","UI/UX","Bharatpur-4, Chitwan","Bitflux Tech. Solution","11"),
                new InternItem("Design Intern","25 Sep, 2026","UI/UX","Bharatpur-4, Chitwan","Bitflux Tech. Solution","11"),
                new InternItem("QA Intern","25 Sep, 2026","UI/UX","Bharatpur-4, Chitwan","Bitflux Tech. Solution","11"),
                new InternItem("Marketing Intern","25 Sep, 2026","UI/UX","Bharatpur-4, Chitwan","Bitflux Tech. Solution","11"),
                new InternItem("Sales Intern","25 Sep, 2026","UI/UX","Bharatpur-4, Chitwan","Bitflux Tech. Solution","11"),
                new InternItem("Admin Intern","25 Sep, 2026","UI/UX","Bharatpur-4, Chitwan","Bitflux Tech. Solution","11"),
                new InternItem("Account Intern","25 Sep, 2026","UI/UX","Bharatpur-4, Chitwan","Bitflux Tech. Solution","11"),
                new InternItem("HR Intern","25 Sep, 2026","UI/UX","Bharatpur-4, Chitwan","Bitflux Tech. Solution","11")
        };


        InternAdapter internAdapter = new InternAdapter(this,internItems);
        RecyclerView rvIntern = findViewById(R.id.rvIntern);
        rvIntern.setLayoutManager(new LinearLayoutManager(this));
        rvIntern.setAdapter(internAdapter);


    }




}





//
//ListView lvInternList = findViewById(R.id.lvIntern);
//String[] internList = {
//        "Intern in Marketing",
//        "Intern in Design",
//        "Intern in Python",
//        "Intern in FullStack"
//};
//
//
//ArrayAdapter<String> internAdapter = new ArrayAdapter<>(this,
//        android.R.layout.simple_list_item_1,internList);
//
//        lvInternList.setAdapter(internAdapter);






