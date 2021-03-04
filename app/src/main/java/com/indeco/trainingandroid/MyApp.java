package com.indeco.trainingandroid;

import android.app.Application;

import com.indeco.trainingandroid.io.local.UserSharedPreferences;
import com.indeco.trainingandroid.notes.io.local.room.AppDatabaseHandler;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UserSharedPreferences.getInstance().setup(this);
        AppDatabaseHandler.getInstance().setup(this);
    }
}
