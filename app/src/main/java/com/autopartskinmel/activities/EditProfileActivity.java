package com.autopartskinmel.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import com.autopartskinmel.R;
import com.google.android.material.button.MaterialButton;

public class EditProfileActivity extends AppCompatActivity {
    private ImageView backButton, editProfileImage;
    private EditText editName, editPhone, editAddress;
    private MaterialButton updateBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        initFields();

        backButton.setOnClickListener(view -> finish());
    }

    private void initFields() {
        backButton = findViewById(R.id.back_arrow);
        editProfileImage = findViewById(R.id.edit_profile);
        editName = findViewById(R.id.edit_full_name_field);
        editPhone = findViewById(R.id.edit_phone_field);
        editAddress = findViewById(R.id.edit_address_field);
        updateBtn = findViewById(R.id.update_btn);
    }
}