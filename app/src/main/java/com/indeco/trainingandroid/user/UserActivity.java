package com.indeco.trainingandroid.user;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.indeco.trainingandroid.R;
import com.indeco.trainingandroid.io.local.UserSharedPreferences;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        EditText et = findViewById(R.id.etUser);
        findViewById(R.id.btnSave).setOnClickListener(v -> {
            String user = et.getText().toString();
            UserSharedPreferences.getInstance().write(UserSharedPreferences.USER, user);
        });

        findViewById(R.id.btnRead).setOnClickListener(v -> {
            String result = UserSharedPreferences.getInstance().read(UserSharedPreferences.USER);
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        });

    }
}