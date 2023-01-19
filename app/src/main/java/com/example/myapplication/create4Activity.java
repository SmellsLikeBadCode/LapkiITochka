package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class create4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create4);
    }

    public void Click4To5(View view) {
        Intent intent = new Intent(create4Activity.this, create5Activity.class);
        startActivity(intent);
    }

    public void ClickBack(View view) {
        finish();
    }
}
