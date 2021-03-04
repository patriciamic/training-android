package com.indeco.trainingandroid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.indeco.trainingandroid.io.remote.UICallable;
import com.indeco.trainingandroid.io.remote.entities.MyModel;
import com.indeco.trainingandroid.io.remote.impl.AsisocImpl;
import com.indeco.trainingandroid.navhost.NavHostActivity;
import com.indeco.trainingandroid.notes.NoteActivity;
import com.indeco.trainingandroid.test.Entity;

import org.json.JSONArray;

import java.util.List;

import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SecondActivity.OnChangedListener {
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btn);
        et = findViewById(R.id.et);
        btn.setOnClickListener(this);

        findViewById(R.id.btnNotes).setOnClickListener(this);
        findViewById(R.id.btnNavHost).setOnClickListener(this);


        try {
            AsisocImpl service = new AsisocImpl();
            service.getMyModels("4", "76770", "202102", new UICallable<Response<List<MyModel>>>() {
                @Override
                public void onResponse(Response<List<MyModel>> listResponse) {
                    Log.e("AAAAAAA", "success " + listResponse.body());
                }

                @Override
                public void onError(String message) {
                    Log.e("AAAAAAA", "error " + message);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn:
                startSecondActivity();
                break;
            case R.id.btnNotes:
                Intent intent = new Intent(this, NoteActivity.class);
                startActivity(intent);
                break;
            case R.id.btnNavHost:
                Intent intentNavHost = new Intent(this, NavHostActivity.class);
                startActivity(intentNavHost);
                break;
        }


    }

    private void startSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        Entity entity = new Entity("Ion");
        intent.putExtra("entitie", entity);
        SecondActivity.setListener(this);
        startActivityForResult(intent, 8);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 8) {

            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra(SecondActivity.EXTRA);
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    public void onChanged(String text) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                et.setText(text);
            }
        });
    }
}