package com.example.mittihub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class janadap extends RecyclerView.Adapter<janadap.jobprofViewHolder> {


    Context context;
    ArrayList<janmodal> minfoList;

    public janadap(Context context, ArrayList<janmodal> minfoList ) {
        this.context = context;
        this.minfoList = minfoList;

    }


    @NonNull
    @Override
    public janadap.jobprofViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.layout_jour, parent, false);
        return new janadap.jobprofViewHolder(v);
    }

    @NonNull
    @Override
    public void onBindViewHolder(@NonNull janadap.jobprofViewHolder holder, int position) {
        janmodal info = minfoList.get(position);

        holder.msg.setText(info.msg);



    }
    @Override
    public int getItemCount() {
        return minfoList.size();
    }

    public static class jobprofViewHolder extends RecyclerView.ViewHolder {
        TextView msg;

        public jobprofViewHolder(View itemView) {
            super(itemView);
            msg= itemView.findViewById(R.id.tvj2);




        }
    }
}
