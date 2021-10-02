package com.autopartskinmel.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import com.autopartskinmel.R;
import com.google.android.material.button.MaterialButton;
import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText emailLoginField, passwordLoginField;
    private MaterialButton loginBtn;
    private TextView register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initFields();

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> finish());

        register.setOnClickListener(view -> openRegisterActivity());
    }

    private void initFields() {
        toolbar = findViewById(R.id.toolbar);
        emailLoginField = findViewById(R.id.email_login_field);
        passwordLoginField = findViewById(R.id.password_login_field);
        loginBtn = findViewById(R.id.login_btn);
        register = findViewById(R.id.register_txt);
    }

    private void openRegisterActivity() {
        startActivity(new Intent(this, RegisterActivity.class));
    }
}