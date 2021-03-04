package com.indeco.trainingandroid.notes.io.local.room;

import com.indeco.trainingandroid.entities.Note;
import com.indeco.trainingandroid.notes.io.local.room.entities.RoomNote;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static Note parse(RoomNote roomNote) {
        return new Note(roomNote.title, roomNote.content);
    }

    public static RoomNote parse(Note note) {
        return new RoomNote(note.getTitle(), note.getContent());
    }

    public static List<Note> parse(List<RoomNote> roomNotes) {
        List<Note> notes = new ArrayList<>();
        for (RoomNote item : roomNotes) {
            notes.add(parse(item));
        }

        return notes;
    }


}
