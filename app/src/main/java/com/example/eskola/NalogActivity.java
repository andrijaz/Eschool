package com.example.eskola;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

public class NalogActivity extends AppCompatActivity {

    private Spinner spinner;
    private EditText ime;
    private EditText prezime;
    private EditText jmbg;
    private EditText email;
    private EditText brojTelefona;
    private FloatingActionButton done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nalog);

        spinner = findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.tipovi_naloga, R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ime = findViewById(R.id.ime);
        prezime = findViewById(R.id.prezime);
        jmbg = findViewById(R.id.jmbg);
        email = findViewById(R.id.email);
        brojTelefona = findViewById(R.id.telefon);

        done = findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("tip_naloga", spinner.getSelectedItem().toString());
                resultIntent.putExtra("ime", ime.getText().toString());
                resultIntent.putExtra("prezime", prezime.getText().toString());
                resultIntent.putExtra("jmbg", jmbg.getText().toString());
                resultIntent.putExtra("email", email.getText().toString());
                resultIntent.putExtra("telefon", brojTelefona.getText().toString());
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });

    }
}
