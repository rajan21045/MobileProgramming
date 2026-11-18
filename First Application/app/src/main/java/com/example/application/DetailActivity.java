package com.example.application;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvTitle = findViewById(R.id.detailTitle);
        TextView tvCompanyName = findViewById(R.id.detailCompanyName);
        TextView tvRole = findViewById(R.id.detailRole);
        TextView tvAddress = findViewById(R.id.detailAddress);
        TextView tvPublishedDate = findViewById(R.id.detailPublishedDate);
        TextView tvAppliedBy = findViewById(R.id.detailAppliedBy);

        tvTitle.setText(getIntent().getStringExtra("title"));
        tvCompanyName.setText(getIntent().getStringExtra("companyName"));
        tvRole.setText(getIntent().getStringExtra("role"));
        tvAddress.setText(getIntent().getStringExtra("address"));
        tvPublishedDate.setText(getIntent().getStringExtra("publishedDate"));

        String appliedBy = getIntent().getStringExtra("appliedByNo");
        tvAppliedBy.setText(appliedBy == null ? "" : appliedBy + " applied");
    }
}