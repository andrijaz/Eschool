package com.example.eskola;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText userName;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        userName = findViewById(R.id.user_name);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser(userName.getText().toString(), password.getText().toString());
            }
        });
    }

    private void loginUser(String userName, String password) {
        if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(password)) {
            Intent intent = getIntentForUserName(userName);
            if (intent != null) {
                startActivity(intent);
            }
        } else {
            Toast.makeText(this, "Unesite korisnicko ime ili lozinku", Toast.LENGTH_SHORT).show();
        }
    }

    private Intent getIntentForUserName(String userName) {
        switch (userName) {
            case "admin":
                return new Intent(LoginActivity.this, AdminActivity.class);
            default:
                Toast.makeText(this, "Neispravni podaci", Toast.LENGTH_SHORT).show();
                return null;
        }
    }
}
