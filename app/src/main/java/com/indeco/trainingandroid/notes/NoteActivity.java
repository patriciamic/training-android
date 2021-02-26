package com.indeco.trainingandroid.notes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.indeco.trainingandroid.R;
import com.indeco.trainingandroid.entities.Note;

public class NoteActivity extends AppCompatActivity implements View.OnClickListener, NotesAdapter.OnClickListener {

    private static final int ADD = 1;
    private static final int UPDATE = 2;
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
        Intent intent = new Intent(this, ItemNoteActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != RESULT_OK) {
            return;
        }

        assert data != null;

        Note note;
        switch (requestCode) {
            case ADD:
                note = (Note) data.getSerializableExtra(ItemNoteActivity.KEY);
                adapter.add(note);
                break;
            case UPDATE:
                note = (Note) data.getSerializableExtra(ItemNoteActivity.UPDATE_KEY);
                int position = data.getIntExtra(ItemNoteActivity.ITEM_POSITION, -1);
                if (position == -1) {
                    return;
                }
                adapter.update(note, position);
                break;
        }

    }

    @Override
    public void onItemClicked(Note note, int position) {
        Intent intent = new Intent(this, ItemNoteActivity.class);
        intent.putExtra(ItemNoteActivity.KEY, note);
        intent.putExtra(ItemNoteActivity.ITEM_POSITION, position);
        startActivityForResult(intent, 2);
    }
}