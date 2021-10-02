package com.autopartskinmel.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.widget.EditText;
import com.autopartskinmel.R;
import com.google.android.material.button.MaterialButton;
import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText emailField, fullNameField, passwordField, confirmPasswordField, phoneNumberField;
    private MaterialButton registerBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initFields();

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> finish());
    }

    private void initFields() {
        toolbar = findViewById(R.id.toolbar);
        emailField = findViewById(R.id.email_field);
        fullNameField = findViewById(R.id.full_name_field);
        passwordField = findViewById(R.id.password_field);
        confirmPasswordField = findViewById(R.id.confirm_password_field);
        phoneNumberField = findViewById(R.id.phone_field);
        registerBtn = findViewById(R.id.register_btn);
    }
}