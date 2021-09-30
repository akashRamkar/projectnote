package com.example.keepnotes;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NodeRepository {
    private NoteDao noteDao;
    private LiveData<List<Note>> allNotes;

    NodeRepository(Application application){
        NoteDatabase db= NoteDatabase.getInstance(application);
        noteDao=db.noteDao();
        allNotes=noteDao.getAllNotes();
    }
    public LiveData<List<Note>> getAllNotes(){
        return allNotes;
    }
    void insert(Note note){
        NoteDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                noteDao.insert(note);
            }
        });
    }

    void deleteNote(Note note){
        NoteDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                noteDao.delete(note);
            }
        });
    }

    void updateNote(Note note){
        NoteDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                noteDao.update(note);
            }
        });
    }

    void deleteAllNotes(){
        NoteDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                noteDao.deleteAllMyNotes();
            }
        });
    }
}

