package com.example.myapplication;

import android.app.Application;

import com.yandex.mapkit.MapKitFactory;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        String MAPKIT_API_KEY = "9578bcc9-08b2-4d0e-855e-44201665bd92";
        MapKitFactory.setApiKey(MAPKIT_API_KEY);
    }
}
