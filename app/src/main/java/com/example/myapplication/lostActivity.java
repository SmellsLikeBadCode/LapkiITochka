package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import adapter.LostAdapter;
import adapter.MainAdapter;
import model.Lost;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class lostActivity extends AppCompatActivity {

    RecyclerView lostRecycler;
    LostAdapter lostAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost);

        lostRecycler = findViewById(R.id.lostRecycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        lostRecycler.setLayoutManager(layoutManager);
        lostRecycler.addItemDecoration(new DividerItemDecoration(lostRecycler.getContext(), DividerItemDecoration.VERTICAL));
        //setLostRecycler(lostList);
        getAllPosts();
    }

    public void getAllPosts(){
        Call<List<UserResponse>> userList = ApiClient.getUserService().getAllUsers();
        userList.enqueue(new Callback<List<UserResponse>>() {
            @Override
            public void onResponse(Call<List<UserResponse>> call, Response<List<UserResponse>> response ) {
                if (response.isSuccessful()){
                    List<UserResponse> userResponses = new ArrayList<>();

                    lostAdapter = new LostAdapter(this, userResponses);
                    for (int i = 0; i < response.body().size(); i++)
                    {
                        if (response.body().get(i).isLost()){
                            userResponses.add(response.body().get(i));
                        }
                        continue;
                    }
                    lostAdapter.setData(userResponses);
                    lostRecycler.setAdapter(lostAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<UserResponse>> call, Throwable t) {
                Log.e("failure", t.getLocalizedMessage());
            }
        });
    }

    /*private void setLostRecycler(List<Lost> lostList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        lostRecycler = findViewById(R.id.lostRecycler);
        lostRecycler.setLayoutManager(layoutManager);
        lostAdapter = new LostAdapter(this, lostList);
        lostRecycler.setAdapter(lostAdapter);

        lostRecycler.addItemDecoration(new DividerItemDecoration(lostRecycler.getContext(), DividerItemDecoration.VERTICAL));
    }*/

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