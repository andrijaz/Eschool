package com.example.eskola.forme;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.eskola.modeli.Osoba;
import com.example.eskola.R;

import java.util.ArrayList;

public class OcenjivanjeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private TextView emptyLabel;
    private RecyclerView recyclerView;
    private static final int NALOG_CONST = 100;
    private NalogAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setTitle("Ocenjivanje");
        setContentView(R.layout.activity_ocenjivanje);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupListOfUsers();
        setupKontrolniFab();
        setupOcenaFab();


    }

    private void setupListOfUsers() {
        recyclerView = findViewById(R.id.usersRecyclerView);
        ArrayList<Osoba> listaNaloga = Osoba.getListOfFakeUcenici();
        adapter = new NalogAdapter(listaNaloga);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                manager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
    private void setupKontrolniFab() {
        FloatingActionButton kontFab = findViewById(R.id.kontrolniFab);
        kontFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OcenjivanjeActivity.this, KontrolniActivity.class);
                startActivityForResult(i, NALOG_CONST);
            }
        });

    }
    private void setupOcenaFab() {
        FloatingActionButton ocenaFab = findViewById(R.id.ocenaFab);
        ocenaFab.setImageResource(R.drawable.grade);
        ocenaFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OcenjivanjeActivity.this, OcenaActivity.class);
                startActivityForResult(i, NALOG_CONST);
            }
        });

    }

}
