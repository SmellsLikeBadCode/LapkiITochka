package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class create2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create2);
    }

    public void Click2To3(View view) {
        Intent intent = new Intent(create2Activity.this, create3Activity.class);
        startActivity(intent);
    }

    public void ClickBack(View view) {
        finish();
    }
}
