package com.example.eskola;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private TextView emptyLabel;
    private RecyclerView recyclerView;
    private NalogAdapter adapter;
    private static final int NALOG_CONST = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        setupToolbar();
        setupDrawer();
        setupEmptyLayout();
        setupListOfUsers();
        setupFab();
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Administrator");
    }

    private void setupDrawer() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void setupEmptyLayout() {
        emptyLabel = findViewById(R.id.empty_label);
        emptyLabel.setVisibility(View.GONE);
    }

    private void setupListOfUsers() {
        recyclerView = findViewById(R.id.recycler_view);
        ArrayList<Nalog> listaNaloga = Nalog.getListOfFakeUsers();
        adapter = new NalogAdapter(listaNaloga);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                manager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

    }

    private void setupFab() {
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminActivity.this, NalogActivity.class);
                startActivityForResult(i, NALOG_CONST);
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nalozi) {

        } else if (id == R.id.informacije) {

        } else if (id == R.id.raspored_odeljenja) {

        } else if (id == R.id.nastavnici) {

        } else if (id == R.id.razredni) {

        } else if (id == R.id.raspored_casova) {

        } else if (id == R.id.sekcija) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case NALOG_CONST:
                if (resultCode == Activity.RESULT_OK) {
                    String tipNaloga = data.getStringExtra("tip_naloga");
                    String ime = data.getStringExtra("ime");
                    String prezime = data.getStringExtra("prezime");
                    String jmbg = data.getStringExtra("jmbg");
                    String email = data.getStringExtra("email");
                    String brojTelefona = data.getStringExtra("telefon");

                    Nalog nalog = new Nalog(tipNaloga, ime, prezime, email, brojTelefona, jmbg);
                    adapter.addNalog(nalog);
                }
                break;

        }
    }
}
