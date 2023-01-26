package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class create5Activity extends AppCompatActivity {

    ImagesCache cache = ImagesCache.getInstance();
    Bundle args;
    UserResponse userResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create5);
        args = getIntent().getExtras();
        if (args != null) {
            userResponse = (UserResponse) args.getSerializable("userResponse");
        }
        EditText editName = findViewById(R.id.editName);
        EditText editPhone = findViewById(R.id.editPhone);
        EditText editMail = findViewById(R.id.editMail);
        editName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                String date = editName.getText().toString();
                userResponse.setName(date);
            }
        });
        editPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                String tel = editPhone.getText().toString();
                userResponse.setTel(tel);
            }
        });
        editMail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String email = editMail.getText().toString();
                userResponse.setEmail(email);
            }
        });
    }

    public void Click5To6(View view) throws IOException {
        Intent intent = new Intent(create5Activity.this, create6Activity.class);
        sendPostRequest(userResponse);
        startActivity(intent);
    }

    public void sendPostRequest(UserResponse userResponse) throws IOException {
        UserService userService = ApiClient.getUserService();
        //Постинг без картинки
        /*Call<UserResponse> call = userService.getUserResponse(
                userResponse.getAddress(),
                userResponse.getAnimalType(),
                userResponse.getDate(),
                userResponse.getGender(),
                userResponse.getName(),
                userResponse.getDescription(),
                userResponse.isLost(),
                userResponse.getGeoLat(),
                userResponse.getGeoLon());*/
        //Постинг с мультипартом
        //Конвертация битмапа в файл

        Bitmap bitmap = cache.getImageFromWarehouse("image");
        File f = new File(this.getCacheDir(), "png");
        f.createNewFile();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0 /*ignored for PNG*/, bos);
        byte[] bitmapdata = bos.toByteArray();
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(bitmapdata);
        fos.flush();
        fos.close();

        RequestBody addressPart = RequestBody.create(MultipartBody.FORM, userResponse.getAddress());
        RequestBody animalPart = RequestBody.create(MultipartBody.FORM, userResponse.getAnimal());
        RequestBody datePart = RequestBody.create(MultipartBody.FORM, userResponse.getDate());
        RequestBody genderPart = RequestBody.create(MultipartBody.FORM, userResponse.getGender());
        RequestBody namePart = RequestBody.create(MultipartBody.FORM, userResponse.getName());
        RequestBody descriptionPart = RequestBody.create(MultipartBody.FORM, userResponse.getDescription());
        RequestBody lostPart = RequestBody.create(MultipartBody.FORM, "false");
        RequestBody geoLatPart = RequestBody.create(MultipartBody.FORM, "00.10");
        RequestBody geoLonPart = RequestBody.create(MultipartBody.FORM, "00.10");
        RequestBody telPart = RequestBody.create(MultipartBody.FORM, userResponse.getTel());
        RequestBody emailPart = RequestBody.create(MultipartBody.FORM, userResponse.getEmail());

        RequestBody imagePart = RequestBody.create(
                MediaType.parse(getContentResolver().getType(getImageUri(this,bitmap))),
                f
        );
        MultipartBody.Part image = MultipartBody.Part.createFormData("image", f.getName(), imagePart);


        Call<UserResponse> call = userService.post(addressPart,
                animalPart,
                datePart,
                genderPart,
                namePart,
                descriptionPart,
                lostPart,
                geoLatPart,
                geoLonPart,
                telPart,
                emailPart,
                image
        );
        //Здесь кончается постинг с мультипартом

        //не удалять
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                Log.e("onResponse", String.valueOf(response.code()));
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.e("failure", t.getLocalizedMessage());
            }
        });
    }
    //Метод для получения URI
    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.PNG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    public void ClickBack(View view) {
        finish();
    }

    public void ClickPets(View view){
        Intent intent = new Intent(create5Activity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void ClickLost(View view) {
        Intent intent = new Intent(create5Activity.this, lostActivity.class);
        startActivity(intent);
        finish();
    }

    public void ClickMap(View view) {
        Intent intent = new Intent(create5Activity.this, mapActivity.class);
        startActivity(intent);
        finish();
    }

    public void ClickProfile(View view) {
        Intent intent = new Intent(create5Activity.this, profileActivity.class);
        startActivity(intent);
        finish();
    }
}