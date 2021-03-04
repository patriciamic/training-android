package com.indeco.trainingandroid.notes.io.local.room.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class RoomNote {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "content")
    public String content;

    public RoomNote(String title, String content) {
        this.title = title;
        this.content = content;
    }

//    public RoomNote(int id, String title, String content) {
//        this.id = id;
//        this.title = title;
//        this.content = content;
//    }
}
