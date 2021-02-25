package com.indeco.trainingandroid.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;
import com.indeco.trainingandroid.R;
import com.indeco.trainingandroid.entities.Note;

public class AddNoteActivity extends AppCompatActivity implements View.OnClickListener {

    public static String KEY = "add new note";

    private EditText etTitle;
    private EditText etContent;
    private TextInputLayout tilTitle;
    private TextInputLayout tilContent;
    private Button btnSave;
    private Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        init();
    }

    private void init() {
        etTitle = findViewById(R.id.etTitle);
        etContent = findViewById(R.id.etContent);
        tilTitle = findViewById(R.id.tilTitle);
        tilContent = findViewById(R.id.tilContent);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);

        btnSave.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave:

                String title = etTitle.getText().toString();
                String content = etContent.getText().toString();

                if (validate(title, content)) {

                    Note note = new Note(title, content);
                    Intent intent = new Intent();
                    intent.putExtra(KEY, note);
                    setResult(RESULT_OK, intent);
                    finish();
                }

                break;
            case R.id.btnCancel:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }

    private boolean validate(String title, String content) {
        if (title.isEmpty()) {
            tilTitle.setError("Camp obligatoriu!");
            return false;
        }

        if (content.isEmpty()) {
            tilContent.setError("Camp obligatoriu!");
            return false;
        }

        return true;
    }
}