package com.example.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;

public class create2Activity extends AppCompatActivity {

    ImagesCache cache = ImagesCache.getInstance();
    Bundle args;
    UserResponse userResponse;
    Bitmap bitmap;
    static final int GALLERY_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create2);
        args = getIntent().getExtras();
        if (args != null){ userResponse = (UserResponse) args.getSerializable("userResponse"); }
        cache.initializeCache();
    }

    public void Click2To3(View view) {
        Intent intent = new Intent(create2Activity.this, create3Activity.class);
        intent.putExtra("userResponse", userResponse);
        startActivity(intent);
    }

    public void ClickBack(View view) {
        finish();
    }

    public void ClickPets(View view){
        Intent intent = new Intent(create2Activity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void ClickLost(View view) {
        Intent intent = new Intent(create2Activity.this, lostActivity.class);
        startActivity(intent);
        finish();
    }

    public void ClickMap(View view) {
        Intent intent = new Intent(create2Activity.this, mapActivity.class);
        startActivity(intent);
        finish();
    }

    public void ClickProfile(View view) {
        Intent intent = new Intent(create2Activity.this, profileActivity.class);
        startActivity(intent);
        finish();
    }

    public void uploadImage(View view) {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, GALLERY_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        Bitmap bitmap = null;

        switch (requestCode) {
            case GALLERY_REQUEST:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = imageReturnedIntent.getData();
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                        cache.addImageToWarehouse("image", bitmap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        }
    }
}

