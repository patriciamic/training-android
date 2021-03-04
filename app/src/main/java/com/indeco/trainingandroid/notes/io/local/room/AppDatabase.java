package com.indeco.trainingandroid.notes.io.local.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.indeco.trainingandroid.notes.io.local.room.dao.NoteDao;
import com.indeco.trainingandroid.notes.io.local.room.entities.RoomNote;

@Database(entities = {RoomNote.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NoteDao getNoteDao();
}
