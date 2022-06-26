package com.example.talentmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SortingAdapter extends RecyclerView.Adapter<SortingAdapter.ViewHolder> {

    Context context;
    List<SortingNilai> nilailist;

    public SortingAdapter(Context context, List<SortingNilai> nilailist) {
        this.context = context;
        this.nilailist = nilailist;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout_sorting,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        if (nilailist != null && nilailist.size() > 0){
            SortingNilai model = nilailist.get(position);
            holder.tvDivisi.setText(model.getTvDivisi());
            holder.tvPersentase.setText(model.getTvPersentase());
        } else {
            return;
        }
    }

    @Override
    public int getItemCount() {
        return nilailist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDivisi, tvPersentase;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvDivisi = itemView.findViewById(R.id.tvDivisi);
            tvPersentase = itemView.findViewById(R.id.tvPersentase);
        }
    }
}
