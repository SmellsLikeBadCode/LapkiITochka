package com.example.myapplication;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UserService {

    @GET("poster/all")
    Call<List<UserResponse>> getAllUsers();

    @Multipart
    @POST("poster")
    Call<UserResponse> post(@Part("address")RequestBody address,
                            @Part("animal")RequestBody animal,
                            @Part("date") RequestBody date,
                            @Part("gender")RequestBody gender,
                            @Part("name")RequestBody name,
                            @Part("description")RequestBody description,
                            @Part("isLost")RequestBody isLost,
                            @Part("geoLat")RequestBody geoLat,
                            @Part("geoLon")RequestBody geoLon,
                            @Part("tel") RequestBody tel,
                            @Part("email") RequestBody email,
                            @Part MultipartBody.Part image);
}