package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class postActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        ImageView postImage = findViewById(R.id.postImage);
        TextView postTitle = findViewById(R.id.postTitle);
        TextView postText = findViewById(R.id.postText);
        TextView postNumber = findViewById(R.id.postNumber);
        TextView postBreed = findViewById(R.id.postBreed);
        TextView postGender = findViewById(R.id.postGender);
        TextView postDate = findViewById(R.id.postDate);
        TextView postDateL = findViewById(R.id.postDateL);

        postImage.setImageResource(getIntent().getIntExtra("postImage", 0));
        postTitle.setText(getIntent().getStringExtra("postTitle"));
        postText.setText(getIntent().getStringExtra("postText"));
        postNumber.setText(getIntent().getStringExtra("postNumber"));
        postBreed.setText(getIntent().getStringExtra("postBreed"));
        postGender.setText(getIntent().getStringExtra("postGender"));
        postDate.setText(getIntent().getStringExtra("postDate"));
        postDateL.setText(getIntent().getStringExtra("postDateL"));
    }
}
