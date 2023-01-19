package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class create5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create5);
    }

    public void Click5To6(View view) {
        Intent intent = new Intent(create5Activity.this, create6Activity.class);
        startActivity(intent);
    }

    public void ClickBack(View view) {
        finish();
    }
}
