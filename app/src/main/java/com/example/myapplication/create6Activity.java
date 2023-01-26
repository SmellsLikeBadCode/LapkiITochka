package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class create6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create6);
    }

    public void ClickPets(View view){
        Intent intent = new Intent(create6Activity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void ClickLost(View view) {
        Intent intent = new Intent(create6Activity.this, lostActivity.class);
        startActivity(intent);
        finish();
    }

    public void ClickMap(View view) {
        Intent intent = new Intent(create6Activity.this, mapActivity.class);
        startActivity(intent);
        finish();
    }

    public void ClickProfile(View view) {
        Intent intent = new Intent(create6Activity.this, profileActivity.class);
        startActivity(intent);
        finish();
    }
}
