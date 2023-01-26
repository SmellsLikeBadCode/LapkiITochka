package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.Objects;

public class postActivity extends AppCompatActivity {


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        ImageView postImage = findViewById(R.id.postImage);

        TextView postTitle = findViewById(R.id.postTitle);
        TextView postText = findViewById(R.id.postText);
        TextView postGender = findViewById(R.id.postGender);
        TextView postDate = findViewById(R.id.postDate);
        TextView postDateL = findViewById(R.id.postDateL);

        String imageURL = getIntent().getExtras().get("url").toString();

        Picasso.get()
                .load(imageURL)
                .fit()
                .into(postImage);

        postImage.setImageResource(getIntent().getIntExtra("postImage", 0));
        postTitle.setText(getIntent().getStringExtra("postTitle"));
        postText.setText(getIntent().getStringExtra("postText"));
        String gender = getIntent().getStringExtra("postGender");
        if (Objects.equals(getIntent().getStringExtra("postGender").toLowerCase(), "male")) { postGender.setText("Мальчик"); }
        if (Objects.equals(getIntent().getStringExtra("postGender").toLowerCase(), "female")) { postGender.setText("Девочка"); }
        postDate.setText(getIntent().getStringExtra("postDate"));
        postDateL.setText(getIntent().getStringExtra("postDateL"));
    }
}
