package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class profileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void ClickPets(View view) {
        Intent intent = new Intent(profileActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void ClickLost(View view) {
        Intent intent = new Intent(profileActivity.this, lostActivity.class);
        startActivity(intent);
        finish();
    }

    public void ClickMap(View view) {
        Intent intent = new Intent(profileActivity.this, mapActivity.class);
        startActivity(intent);
        finish();
    }

    public void ClickSettings(View view) {
        Intent intent = new Intent(profileActivity.this, settingsActivity.class);
        startActivity(intent);
        finish();
    }

    public void ClickCreate(View view) {
        Intent intent = new Intent(profileActivity.this, create1Activity.class);
        startActivity(intent);
        finish();
    }
}

