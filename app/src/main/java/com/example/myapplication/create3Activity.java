package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class create3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create3);
    }

    public void Click3To4(View view) {
        Intent intent = new Intent(create3Activity.this, create4Activity.class);
        startActivity(intent);
    }

    public void ClickBack(View view) {
        finish();
    }
}
