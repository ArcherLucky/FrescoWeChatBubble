package com.archer.frescochatimage;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 接管Application
 * Created by 84113 on 2017/2/18.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
