package com.example.notes.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.notes.dao.NoteDao;
import com.example.notes.entities.Note;

@Database(entities = Note.class,version = 1,exportSchema = false)
public abstract class NoteDatabase extends RoomDatabase {
    private static NoteDatabase noteDateBase;
    public static synchronized NoteDatabase getNoteDateBase(Context context) {
        if (noteDateBase == null) {
            noteDateBase = Room.databaseBuilder(
                    context,
                    NoteDatabase.class,
                    "note_db"
            ).build();
        }
        return noteDateBase;
    }
    public abstract NoteDao noteDao();
}
