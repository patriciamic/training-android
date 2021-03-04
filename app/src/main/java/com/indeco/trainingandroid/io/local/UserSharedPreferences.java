package com.indeco.trainingandroid.io.local;

import android.content.Context;
import android.content.SharedPreferences;

public class UserSharedPreferences {

    public static final String USER = "user";
    private static UserSharedPreferences instance;
    private static final Object LOCK = new Object();
    private SharedPreferences sharedPref;


    private UserSharedPreferences() {
    }

    public static UserSharedPreferences getInstance() {
        if (instance == null) {
            synchronized (LOCK) {
                if (instance == null) {
                    instance = new UserSharedPreferences();
                }
            }
        }

        return instance;
    }


    public void setup(Context context) {
        if (sharedPref != null) {
            throw new IllegalStateException("setup already made");
        }
        sharedPref = context.getSharedPreferences("user shared preferences", Context.MODE_PRIVATE);
    }

    public String read(String key) {
        return sharedPref.getString(key, "");
    }

    public void write(String key, String value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.apply();
    }


}
