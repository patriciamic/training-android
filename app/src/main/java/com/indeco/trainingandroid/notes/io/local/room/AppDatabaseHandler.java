package com.indeco.trainingandroid.notes.io.local.room;

import android.content.Context;

import androidx.room.Room;

public class AppDatabaseHandler {

    private AppDatabase db;
    private static AppDatabaseHandler instance;
    private static final Object LOCK = new Object();

    private AppDatabaseHandler() {
    }

    public static AppDatabaseHandler getInstance() {

        if (instance == null) {
            synchronized (LOCK) {
                if (instance == null) {
                    instance = new AppDatabaseHandler();
                }
            }
        }

        return instance;
    }

    public void setup(Context context) {
        try{
            db = Room.databaseBuilder(context,
                    AppDatabase.class, "notes database").build();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public AppDatabase getDb() {
        return db;
    }
}
