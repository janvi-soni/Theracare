package com.example.mittihub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class viadapter extends RecyclerView.Adapter<viadapter.jobprofViewHolder> {

    Context context;
    ArrayList<Modalclassjo> infoList;
    private final RecyclerViewInterface recyclerViewInterface;
    public viadapter(Context context, ArrayList<Modalclassjo> infoList,RecyclerViewInterface recyclerViewInterface ) {
        this.context = context;
        this.infoList = infoList;
        this.recyclerViewInterface=recyclerViewInterface;

    }

    @NonNull
    @Override
    public jobprofViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.layout_jobprof, parent, false);
        return new jobprofViewHolder(v,recyclerViewInterface);
    }

    @NonNull
    @Override
    public void onBindViewHolder(@NonNull jobprofViewHolder holder, int position) {
        Modalclassjo info = infoList.get(position);
        holder.textgroupname.setText(info.group);

    }
    @Override
    public int getItemCount() {
        return infoList.size();
    }

    public static class jobprofViewHolder extends RecyclerView.ViewHolder {
        TextView textgroupname;

        public jobprofViewHolder(View itemView,RecyclerViewInterface recyclerViewInterface ) {
            super(itemView);
            textgroupname = itemView.findViewById(R.id.tv1);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface!=null)
                    {
                        int pos=getAdapterPosition();
                        if(pos!=RecyclerView.NO_POSITION)
                        {
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }


                }
            });



        }
    }
}


