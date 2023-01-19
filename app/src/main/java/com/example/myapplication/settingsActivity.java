package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class settingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void ClickPets(View view) {
        Intent intent = new Intent(settingsActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void ClickLost(View view) {
        Intent intent = new Intent(settingsActivity.this, lostActivity.class);
        startActivity(intent);
    }

    public void ClickMap(View view) {
        Intent intent = new Intent(settingsActivity.this, mapActivity.class);
        startActivity(intent);
    }
}
