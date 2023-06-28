package com.example.not_bad.fragmentfav;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.not_bad.DataBase.model;
import com.example.not_bad.R;

import java.util.ArrayList;

public class Frag_AD extends RecyclerView.Adapter<Frag_AD.ViewHolder> {
    ArrayList<model>mo;

    public Frag_AD(ArrayList<model> mo) {
        this.mo = mo;
    }

    @NonNull
    @Override
    public Frag_AD.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.frag,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Frag_AD.ViewHolder holder, int position) {
        holder.tx_title_frag.setText(mo.get(position).getTitel());
        holder.tx_time_frag.setText(mo.get(position).getTime());
        holder.tx_msg_frag.setText(mo.get(position).getMsg());

    }

    @Override
    public int getItemCount() {
        return mo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tx_title_frag,tx_time_frag,tx_msg_frag;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tx_msg_frag=itemView.findViewById(R.id.tx_msg_frag);
            tx_time_frag=itemView.findViewById(R.id.tx_time_frag);
            tx_title_frag=itemView.findViewById(R.id.tx_title_frag);
        }
    }
}
