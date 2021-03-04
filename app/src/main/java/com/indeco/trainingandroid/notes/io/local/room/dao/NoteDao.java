package com.indeco.trainingandroid.notes.io.local.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.indeco.trainingandroid.notes.io.local.room.entities.RoomNote;

import java.util.List;

@Dao
public interface  NoteDao {
    @Query("SELECT * FROM roomnote")
    List<RoomNote> getAll();

    @Query("SELECT * FROM roomnote WHERE id IN (:userIds)")
    List<RoomNote> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM roomnote WHERE title LIKE :first AND " +
            "title LIKE :last LIMIT 1")
    RoomNote findByTitle(String first, String last);

    @Insert
    void insertAll(RoomNote... roomNotes);

    @Insert
    void insert(RoomNote roomNote);

    @Delete
    void delete(RoomNote roomNote);
}
