package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class create1Activity extends AppCompatActivity {

    UserResponse userResponse = new UserResponse();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create1);

        RadioGroup radioGroupType = findViewById(R.id.radioGroupType);
        RadioGroup radioGroupGender = findViewById(R.id.radioGroupGender);
        RadioGroup radioGroupLost = findViewById(R.id.radioGroupLost);

        radioGroupLost.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
                switch (checkId){
                    case R.id.radioButtonLost:
                        userResponse.setLost(true);
                        break;
                    case R.id.radioButtonFound:
                        userResponse.setLost(false);
                        break;
                    case -1:
                        break;
                }
            }
        });

        radioGroupType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
                switch (checkId){
                    case R.id.radioButtonDog:
                        userResponse.setAnimal("dog");
                        break;
                    case R.id.radioButtonCat:
                        userResponse.setAnimal("cat");
                        break;
                    case -1:
                        break;
                }
            }
        });

        radioGroupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
                switch (checkId){
                    case R.id.radioButtonBoy:
                        userResponse.setGender("male");
                        break;
                    case R.id.radioButtonGirl:
                        userResponse.setGender("female");
                        break;
                    case -1:
                        break;
                }
            }
        });
    }

    public void Click1To2(View view) {
        Intent intent = new Intent(create1Activity.this, create2Activity.class);
        intent.putExtra("userResponse", userResponse);
        startActivity(intent);
    }
    public void ClickPets(View view){
        Intent intent = new Intent(create1Activity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void ClickLost(View view) {
        Intent intent = new Intent(create1Activity.this, lostActivity.class);
        startActivity(intent);
        finish();
    }

    public void ClickMap(View view) {
        Intent intent = new Intent(create1Activity.this, mapActivity.class);
        startActivity(intent);
        finish();
    }

    public void ClickProfile(View view) {
        Intent intent = new Intent(create1Activity.this, profileActivity.class);
        startActivity(intent);
        finish();
    }
}
