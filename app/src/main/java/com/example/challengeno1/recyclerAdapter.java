package com.example.challengeno1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {

    private List<GameResult> results;

    public recyclerAdapter(List<GameResult> results){
        this.results = results;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView miTextView;
        private TextView viTextView;

        public MyViewHolder(final View view){
            super(view);
            miTextView = view.findViewById(R.id.textViewResultMi);
            viTextView = view.findViewById(R.id.textViewResultVi);
        }
    }

    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
        GameResult result = results.get(position);
        holder.miTextView.setText(String.valueOf(result.getMiResult()));
        holder.viTextView.setText(String.valueOf(result.getViResult()));
    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}
