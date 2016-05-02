package com.epicodus.myrestaurants;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Guest on 5/2/16.
 */
public class MyRestaurantsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
