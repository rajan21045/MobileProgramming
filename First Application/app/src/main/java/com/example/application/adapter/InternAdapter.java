
package com.example.application.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application.DetailActivity;
import com.example.application.R;
import com.example.application.module.InternItem;

public class InternAdapter
        extends RecyclerView.Adapter<InternAdapter.InternViewHolder> {

    private final Context context;
    private final InternItem[] internItems;

    public InternAdapter(Context context, InternItem[] items) {
        this.context = context;
        this.internItems = items;
    }

    @NonNull
    @Override
    public InternViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.intern_items, parent, false);

        return new InternViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull InternViewHolder holder,
            int position) {

        InternItem currentItem = internItems[position];

        holder.tvTitle.setText(currentItem.getTitle());
        holder.tvRole.setText(currentItem.getRole());
        holder.tvCompanyName.setText(currentItem.getCompanyName());
        holder.tvPublishedDate.setText(currentItem.getPublishedDate());

        // Open internship details when a card is clicked
        holder.cvIntern.setOnClickListener(view -> {

            Intent intent = new Intent(context, DetailActivity.class);

            intent.putExtra("title", currentItem.getTitle());
            intent.putExtra("companyName", currentItem.getCompanyName());
            intent.putExtra("role", currentItem.getRole());
            intent.putExtra("publishedDate", currentItem.getPublishedDate());
            intent.putExtra("address", currentItem.getAddress());
            intent.putExtra("appliedByNo", currentItem.getAppliedByNo());

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return internItems == null ? 0 : internItems.length;
    }

    public static class InternViewHolder
            extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvRole;
        TextView tvCompanyName;
        TextView tvPublishedDate;
        CardView cvIntern;

        public InternViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.internTitle);
            tvRole = itemView.findViewById(R.id.internRole);
            tvCompanyName = itemView.findViewById(R.id.internCompanyName);
            tvPublishedDate = itemView.findViewById(R.id.internPublishedDate);
            cvIntern = itemView.findViewById(R.id.cvIntern);
        }
    }
}