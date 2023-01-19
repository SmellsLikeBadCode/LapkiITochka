package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import adapter.LostAdapter;
import model.Lost;

public class lostActivity extends AppCompatActivity {

    RecyclerView lostRecycler;
    LostAdapter lostAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost);

        List<Lost> lostList = new ArrayList<>();
        lostList.add(new Lost('1', "cat1", "Потерялся кот неизвестной породы, на вид полосатый и довольно глупый, просьба верну...", "Екатеринбург, ул. Луначарского 51", "text", "number", "breed", "gender", "date", "dateL"));
        lostList.add(new Lost('2', "cat2", "Потерялась кошка породы саванна, окликается на кличку Паприка, последний раз видели...", "Екатеринбург, ул. Азина, 20к2", "text", "number", "breed", "gender", "date", "dateL"));
        lostList.add(new Lost('3', "cat3", "Потерялся серый кот Сажа, очень опасен и агресивен, просьба вернуть по следующему а...", "Екатеринбург, ул. Испанских рабочих, 35", "text",  "number", "breed", "gender", "date", "dateL"));
        setLostRecycler(lostList);
    }

    private void setLostRecycler(List<Lost> lostList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        lostRecycler = findViewById(R.id.lostRecycler);
        lostRecycler.setLayoutManager(layoutManager);
        lostAdapter = new LostAdapter(this, lostList);
        lostRecycler.setAdapter(lostAdapter);

        lostRecycler.addItemDecoration(new DividerItemDecoration(lostRecycler.getContext(), DividerItemDecoration.VERTICAL));
    }

    public void ClickPets(View view) {
        Intent intent = new Intent(lostActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void ClickMap(View view) {
        Intent intent = new Intent(lostActivity.this, mapActivity.class);
        startActivity(intent);
        finish();
    }

    public void ClickProfile(View view) {
        Intent intent = new Intent(lostActivity.this, profileActivity.class);
        startActivity(intent);
        finish();
    }

}