package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import adapter.PostAdapter;
import model.Post;

public class MainActivity extends AppCompatActivity {

    RecyclerView postRecycler;
    PostAdapter postAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Post> postList = new ArrayList<>();
        postList.add(new Post('1', "cat1", "Кеша, вредный и наглый", "Екатеринбург, ул. Коминтерна", "В добрые руки"));
        postList.add(new Post('2', "cat2", "Гоша, ласковый и милый", "Москва, ул. Первомайская", "В добрые руки"));
        postList.add(new Post('3', "cat3", "Изя, интересный и красивый", "Челябинск, ул. Ленина", "5000 рублей"));
        postList.add(new Post('4', "cat4", "Вова, хороший и пушистый", "Санкт-Петербург, ул. Сталина", "10000 рублей"));
        setPostRecycler(postList);
    }

    private void setPostRecycler(List<Post> postList) {

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false);
        postRecycler = findViewById(R.id.postRecycler);
        postRecycler.setLayoutManager(layoutManager);
        postAdapter = new PostAdapter(this, postList);
        postRecycler.setAdapter(postAdapter);
    }

    public void ClickLost(View view) {
        Intent intent = new Intent(MainActivity.this, lostActivity.class);
        startActivity(intent);
    }

    public void ClickMap(View view) {
        Intent intent = new Intent(MainActivity.this, mapActivity.class);
        startActivity(intent);
    }
}