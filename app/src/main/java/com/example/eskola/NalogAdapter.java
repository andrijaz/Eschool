package com.example.eskola;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class NalogAdapter extends
        RecyclerView.Adapter<NalogAdapter.ViewHolder> {

    private ArrayList<Nalog> listaNaloga;

    public NalogAdapter(ArrayList<Nalog> listaNaloga) {
        this.listaNaloga = listaNaloga;
    }

    @NonNull
    @Override
    public NalogAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.nalog_item, parent, false);

        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull NalogAdapter.ViewHolder holder, int position) {
        Nalog nalog = listaNaloga.get(position);

        TextView osnovniPodaci = holder.osnovniPodaci;
        osnovniPodaci.setText(String.format("%s %s, %s, %s", nalog.getIme(), nalog.getPrezime(), nalog.getEmail(), nalog.getBrTelefona()));

        TextView tipNaloga = holder.tipNaloga;
        tipNaloga.setText(nalog.getTipNaloga());
    }

    @Override
    public int getItemCount() {
        return listaNaloga.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView osnovniPodaci;
        public TextView tipNaloga;

        public ViewHolder(View itemView) {
            super(itemView);

            osnovniPodaci = itemView.findViewById(R.id.osnovni_podaci);
            tipNaloga = itemView.findViewById(R.id.tip_naloga);
        }
    }

    public void addNalog(Nalog nalog) {
        listaNaloga.add(nalog);
        notifyDataSetChanged();
    }
}
