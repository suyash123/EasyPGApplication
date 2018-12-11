package com.easy.pg.app;

import android.app.Application;

public class EasyPGApplication extends Application{

    private static EasyPGApplication _application;

    @Override
    public void onCreate() {
        super.onCreate();
        _application = this;
    }

    public static EasyPGApplication getInstance() {
        return _application;
    }
}
