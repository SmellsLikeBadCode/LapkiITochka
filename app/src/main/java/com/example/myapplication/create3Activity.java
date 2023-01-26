package com.example.myapplication;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class create3Activity extends AppCompatActivity {

    Bundle args;
    UserResponse userResponse;
    Calendar dateAndTime = Calendar.getInstance();
    TextView editDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create3);
        editDate = findViewById(R.id.textDate);
        EditText editAddress = findViewById(R.id.editAddress);
        args = getIntent().getExtras();
        if (args != null){ userResponse = (UserResponse) args.getSerializable("userResponse"); }


        editAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String address = editAddress.getText().toString();
                userResponse.setAddress(address);
            }
        });

    }

    public void Click3To4(View view) {
        Intent intent = new Intent(create3Activity.this, create4Activity.class);
        intent.putExtra("userResponse", userResponse);
        startActivity(intent);
    }

    public void ClickBack(View view) {
        finish();
    }

    public void setDate(View view) {
        new DatePickerDialog(create3Activity.this, d,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH)
                ).show();
    }
    DatePickerDialog.OnDateSetListener d=new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            int year1 = dateAndTime.get(Calendar.YEAR);
            int month1 = dateAndTime.get(Calendar.MONTH)+1;
            int day1 = dateAndTime.get(Calendar.DAY_OF_MONTH);
            String strD = "";
            String strM = "";
            String strY = String.valueOf(year1);
            if (month1 < 10) { strM = "0"+String.valueOf(month1); }
            else { strM = String.valueOf(month1); }
            if (day1 < 10) { strD = "0"+String.valueOf(day1); }
            else { strD = String.valueOf(day1); }
            userResponse.setDate(strY+"-"+strM+"-"+strD);
            editDate.setText(new StringBuilder()
                    .append(day1)
                    .append(".")
                    .append(strM)
                    .append(".")
                    .append(year1));
        }
    };
    public void ClickPets(View view){
        Intent intent = new Intent(create3Activity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void ClickLost(View view) {
        Intent intent = new Intent(create3Activity.this, lostActivity.class);
        startActivity(intent);
        finish();
    }

    public void ClickMap(View view) {
        Intent intent = new Intent(create3Activity.this, mapActivity.class);
        startActivity(intent);
        finish();
    }

    public void ClickProfile(View view) {
        Intent intent = new Intent(create3Activity.this, profileActivity.class);
        startActivity(intent);
        finish();
    }
}
