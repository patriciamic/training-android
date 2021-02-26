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

public class ItemNoteActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String ITEM_POSITION = "item position";
    public static String KEY = "add new note";
    public static String UPDATE_KEY = "update note";

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

        Intent intent = getIntent();
        if (intent.hasExtra(KEY)) {
            Note note = (Note) intent.getSerializableExtra(KEY);
            etTitle.setText(note.getTitle());
            etContent.setText(note.getContent());
        }
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
                    Intent intent = getNoteIntent(note);
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

    private Intent getNoteIntent(Note note) {
        Intent intent = new Intent();

        if (getIntent().hasExtra(KEY)) {
            intent.putExtra(UPDATE_KEY, note);
            intent.putExtra(ITEM_POSITION, getIntent().getIntExtra(ITEM_POSITION, -1));
        } else {
            intent.putExtra(KEY, note);
        }
        return intent;
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