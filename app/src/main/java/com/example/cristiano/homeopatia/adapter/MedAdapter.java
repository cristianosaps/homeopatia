package com.example.cristiano.homeopatia.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cristiano.homeopatia.Entidades.Composto;
import com.example.cristiano.homeopatia.MedActivity;
import com.example.cristiano.homeopatia.R;

import java.util.List;

/**
 * Created by lfelipeeb on 30/01/17.
 */

public class MedAdapter extends RecyclerView.Adapter<MedAdapter.ViewHolder>{
    public MedAdapter(List<Composto> medList, Context ctx) {
        this.medList = medList;
        this.ctx = ctx;
    }

    private List<Composto> medList;
    private Context ctx;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_med, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.titleMed.setText(medList.get(position).getMedicamento().getNome_med());
        holder.titleMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(ctx, MedActivity.class);
                it.putExtra("idMed", medList.get(position).getMedicamento().getMedicamentoId());
                ctx.startActivity(it);
            }
        });
    }

    @Override
    public int getItemCount() {
        return medList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView titleMed;

        public ViewHolder(View itemView) {
            super(itemView);
            titleMed  = (TextView) itemView.findViewById(R.id.titleMed);
        }
    }
}
