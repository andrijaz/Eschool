package com.example.eskola.forme;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.eskola.R;

public class KontrolniActivity extends AppCompatActivity {
    private Spinner ucenikSpinner;
    private Spinner predmetSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontrolni);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ucenikSpinner = findViewById(R.id.ucenikSpinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.imena_ucenika, R.layout.support_simple_spinner_dropdown_item);
        ucenikSpinner.setAdapter(adapter);

        predmetSpinner = findViewById(R.id.predmetSpinner);
        ArrayAdapter adapterPredmet = ArrayAdapter.createFromResource(this, R.array.naziv_predmeta, R.layout.support_simple_spinner_dropdown_item);
        predmetSpinner.setAdapter(adapterPredmet);



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setImageResource(R.drawable.ic_done_black_24dp);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Kontrolni sacuvan", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
