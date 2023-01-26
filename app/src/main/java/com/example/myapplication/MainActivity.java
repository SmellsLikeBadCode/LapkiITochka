package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import adapter.MainAdapter;
import adapter.PostAdapter;
import model.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView postRecycler;
    MainAdapter mainAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false);
        postRecycler = findViewById(R.id.postRecycler);
        postRecycler.setLayoutManager(layoutManager);
        getAllPosts();
    }

    public void getAllPosts(){
        Call<List<UserResponse>> userList = ApiClient.getUserService().getAllUsers();
        userList.enqueue(new Callback<List<UserResponse>>() {
            @Override
            public void onResponse(Call<List<UserResponse>> call, Response<List<UserResponse>> response ) {
                if (response.isSuccessful()){
                    List<UserResponse> userResponses = new ArrayList<>();
                    int postCount = response.body().size();
                    mainAdapter = new MainAdapter(this, userResponses);
                    for (int i = 0; i < postCount; i++)
                    {
                        if (!response.body().get(i).isLost()){
                            userResponses.add(response.body().get(i));
                        }
                        continue;
                    }
                    mainAdapter.setData(userResponses);
                    postRecycler.setAdapter(mainAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<UserResponse>> call, Throwable t) {
                Log.e("failure", t.getLocalizedMessage());
            }
        });
    }


    public void ClickLost(View view) {
        Intent intent = new Intent(MainActivity.this, lostActivity.class);
        startActivity(intent);
        finish();
    }

    public void ClickMap(View view) {
        Intent intent = new Intent(MainActivity.this, mapActivity.class);
        startActivity(intent);
        finish();
    }

    public void ClickProfile(View view) {
        Intent intent = new Intent(MainActivity.this, profileActivity.class);
        startActivity(intent);
        finish();
    }
}