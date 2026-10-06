package com.example.application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application.module.InternItem;

public class InternAdapter extends RecyclerView.Adapter<InternAdapter.InternViewHolder> {
    private Context context;
    private InternItem[] internItems;

    public InternAdapter(Context context, InternItem[] items) {
        this.context = context;
        this.internItems = items;
    }

    @NonNull
    @Override
    public InternViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View internItemView = inflater.inflate(
                R.layout.intern_items,
                parent,
                false
        );

        return new InternViewHolder(internItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InternViewHolder holder, int position) {

        holder.tvTitle.setText(internItems[position].getTitle());

        holder.tvCompanyName.setText(
                internItems[position].getCompanyName()
        );

        holder.tvRole.setText(
                internItems[position].getRole()
        );
    }

    @Override
    public int getItemCount() {
        return internItems.length;
    }

    public static class InternViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvCompanyName;
        TextView tvRole;

        public InternViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvCompanyName = itemView.findViewById(R.id.tvCompanyName);
            tvRole = itemView.findViewById(R.id.tvRole);
        }
    }

}
