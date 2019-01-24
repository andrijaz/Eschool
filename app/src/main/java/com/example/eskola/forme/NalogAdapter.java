package com.example.eskola.forme;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.eskola.R;
import com.example.eskola.modeli.Osoba;

import java.util.ArrayList;

public class NalogAdapter extends
        RecyclerView.Adapter<NalogAdapter.ViewHolder> {

    private ArrayList<Osoba> listaNaloga;

    public NalogAdapter(ArrayList<Osoba> listaNaloga) {
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
        Osoba osoba = listaNaloga.get(position);

        TextView osnovniPodaci = holder.osnovniPodaci;
        osnovniPodaci.setText(String.format("%s %s, %s, %s", osoba.getIme(), osoba.getPrezime(), osoba.getEmail(), osoba.getBrTelefona()));

        TextView tipNaloga = holder.tipNaloga;
        tipNaloga.setText(osoba.getTipNaloga());
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

            osnovniPodaci = itemView.findViewById(R.id.userDataTxTView);
            tipNaloga = itemView.findViewById(R.id.userTypeTxtView);
        }
    }

    public void addNalog(Osoba osoba) {
        listaNaloga.add(osoba);
        notifyDataSetChanged();
    }
}
