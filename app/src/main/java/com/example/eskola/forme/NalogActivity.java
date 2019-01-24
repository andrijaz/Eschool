package com.example.eskola.forme;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.eskola.R;

public class NalogActivity extends AppCompatActivity {

    private Spinner spinner;
    private EditText ime;
    private EditText prezime;
    private EditText jmbg;
    private EditText email;
    private EditText brojTelefona;
    private FloatingActionButton done;
    private String tipNaloga;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nalog);

        spinner = findViewById(R.id.typeOfAccountSpinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.tipovi_naloga, R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ime = findViewById(R.id.nameEditTxt);
        prezime = findViewById(R.id.surnameEditTxt);
        jmbg = findViewById(R.id.jmbgEditTxt);
        email = findViewById(R.id.emailEditTxt);
        brojTelefona = findViewById(R.id.phoneEditTxt);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                tipNaloga = (String) parent.getItemAtPosition(i);
                if(tipNaloga.equals("Ucenik")) {
                    jmbg.setVisibility(View.GONE);
                }
                else {
                    jmbg.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        done = findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("tip_naloga", tipNaloga);
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
