package com.indeco.trainingandroid.notes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.indeco.trainingandroid.R;
import com.indeco.trainingandroid.entities.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteActivity extends AppCompatActivity implements View.OnClickListener, NotesAdapter.OnClickListener {

    private NotesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);


        findViewById(R.id.btnAddNote).setOnClickListener(this);

        RecyclerView rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NotesAdapter();
        adapter.setOnClickedListener(this);
        rv.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, AddNoteActivity.class);
        startActivityForResult(intent, 10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            assert data != null;
            Note note = (Note) data.getSerializableExtra(AddNoteActivity.KEY);
            adapter.add(note);
        }

    }

    @Override
    public void onItemClicked(Note note) {
        Toast.makeText(this, note.getTitle() + " " + note.getContent(), Toast.LENGTH_SHORT).show();
    }
}