package com.yuanyang.json2view_java;

import android.app.Application;

import com.didi.hummer.Hummer;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Hummer.init(this);
    }
}
