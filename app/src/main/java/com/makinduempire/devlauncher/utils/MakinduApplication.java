package com.makinduempire.devlauncher.utils;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * Created by Makindu ExpressC on 13/04/2017.
 */

public class MakinduApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
