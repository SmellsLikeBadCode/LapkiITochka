package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class create4Activity extends AppCompatActivity {

    Bundle args;
    UserResponse userResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create4);
        args = getIntent().getExtras();
        if (args != null){ userResponse = (UserResponse) args.getSerializable("userResponse"); }
        EditText editDescription = findViewById(R.id.editDescription);
        editDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                String date = editDescription.getText().toString();
                userResponse.setDescription(date);
            }
        });
    }

    public void Click4To5(View view) {
        Intent intent = new Intent(create4Activity.this, create5Activity.class);
        intent.putExtra("userResponse", userResponse);
        startActivity(intent);
    }

    public void ClickBack(View view) {
        finish();
    }

    public void ClickPets(View view){
        Intent intent = new Intent(create4Activity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void ClickLost(View view) {
        Intent intent = new Intent(create4Activity.this, lostActivity.class);
        startActivity(intent);
        finish();
    }

    public void ClickMap(View view) {
        Intent intent = new Intent(create4Activity.this, mapActivity.class);
        startActivity(intent);
        finish();
    }

    public void ClickProfile(View view) {
        Intent intent = new Intent(create4Activity.this, profileActivity.class);
        startActivity(intent);
        finish();
    }
}
