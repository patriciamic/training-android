package com.indeco.trainingandroid.notes.viewmodel;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.indeco.trainingandroid.entities.Note;
import com.indeco.trainingandroid.notes.io.local.room.AppDatabaseHandler;
import com.indeco.trainingandroid.notes.io.local.room.Parser;
import com.indeco.trainingandroid.notes.io.local.room.dao.NoteDao;

import java.util.List;

public class NotesViewModel extends ViewModel {
    private MutableLiveData<List<Note>> notesMutableLiveData = new MutableLiveData<>();
    private NoteDao noteDao;
    private HandlerThread notesHandlerThread;

    public LiveData<List<Note>> getNotesLiveData() {
        return notesMutableLiveData;
    }

    public void getNotes() {

        List<Note> list1 = notesMutableLiveData.getValue();
        if (list1 != null) {
            notesMutableLiveData.postValue(list1);
            return;
        }

        notesHandlerThread = new HandlerThread("notes handler");
        notesHandlerThread.start();

        Handler notesHandler = new Handler(notesHandlerThread.getLooper());
        notesHandler.post(() -> {
            Log.e("AAAAA", Thread.currentThread().getName());
            List<Note> list = doGetNotes();

            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(() -> {
                        Log.e("AAAAA", Thread.currentThread().getName());
                        notesMutableLiveData.postValue(list);
                    }
            );
        });

    }

    private List<Note> doGetNotes() {
        noteDao = AppDatabaseHandler.getInstance().getDb().getNoteDao();
        return Parser.parse(noteDao.getAll());
    }

    public void addNote(Note note) {

        notesHandlerThread = new HandlerThread("notes handler");
        notesHandlerThread.start();

        Handler notesHandler = new Handler(notesHandlerThread.getLooper());
        notesHandler.post(() -> {

            Log.e("AAAAA", Thread.currentThread().getName());
            doAddNote(note);
            List<Note> list = notesMutableLiveData.getValue();
            assert list != null;
            list.add(note);

            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(() -> {
                        Log.e("AAAAA", Thread.currentThread().getName());
                        notesMutableLiveData.postValue(list);
                    }
            );
        });
    }

    private void doAddNote(Note note) {
        noteDao.insert(Parser.parse(note));
    }

}
