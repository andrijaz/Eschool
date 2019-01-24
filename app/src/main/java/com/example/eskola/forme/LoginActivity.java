package com.example.eskola.forme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eskola.R;

public class LoginActivity extends AppCompatActivity {

    private EditText userName;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        userName = findViewById(R.id.userNameEditTxt);
        password = findViewById(R.id.passwordEditTxt);
        login = findViewById(R.id.loginButton);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser(userName.getText().toString(), password.getText().toString());
            }
        });
    }

    private void loginUser(String userName, String password) {
        if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(password)) {
            Intent intent = getIntentForUserName(userName,password);
            if (intent != null) {
                startActivity(intent);
            }
        } else {
            Toast.makeText(this, "Unesite korisnicko ime i lozinku", Toast.LENGTH_SHORT).show();
        }
    }

    private Intent getIntentForUserName(String userName,String password) {
        switch (userName) {
            case "admin": {
                if(password.equals("admin"))
                    return new Intent(LoginActivity.this, AdminActivity.class);
                else {
                    Toast.makeText(this, "Neispravni podaci", Toast.LENGTH_SHORT).show();
                    return null;
                }
            }
            case "nastavnik":{
                if(password.equals("nastavnik"))
                    return new Intent(LoginActivity.this, NastavnikActivity.class);
                else {
                    Toast.makeText(this, "Neispravni podaci", Toast.LENGTH_SHORT).show();
                    return null;
                }

            }
            case "mama": {
                if (password.equals("tata"))
                    return new Intent(LoginActivity.this, RoditeljActivity.class);
                else {
                    Toast.makeText(this, "Neispravni podaci", Toast.LENGTH_SHORT).show();
                    return null;
                }
            }
            default:
                Toast.makeText(this, "Neispravni podaci", Toast.LENGTH_SHORT).show();
                return null;
        }
    }
}
