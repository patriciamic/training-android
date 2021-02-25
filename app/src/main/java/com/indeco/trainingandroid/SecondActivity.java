package com.indeco.trainingandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.indeco.trainingandroid.test.Entity;

import java.io.Serializable;

public class SecondActivity extends AppCompatActivity {

    public static String EXTRA = "secondActicityExtra";

    private static  OnChangedListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        EditText etText = findViewById(R.id.etText);

        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = etText.getText().toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        listener.onChanged(text);
                        finish();
                    }
                }).start();

//                Intent intent = new Intent();
//                intent.putExtra(EXTRA, text);
//                setResult(RESULT_OK, intent);
//                onBackPressed();
//                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.e("AAAAAAA", "second activity back pressed");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.e("AAAAAAA", "second activity on desttroy");
    }

    public static void setListener(OnChangedListener changedListener){
        listener = changedListener;
    }

    interface OnChangedListener{
        void onChanged(String text);
    }


}