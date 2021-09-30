package com.example.keepnotes;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class Noteviewmodel extends AndroidViewModel {
    private NodeRepository repository;
    private LiveData<List<Note>> allNotes;
    public Noteviewmodel(@NonNull Application application) {
        super(application);
        repository=new NodeRepository(application);
        allNotes=repository.getAllNotes();
    }
    //getter
    LiveData<List<Note>> getAllNotes(){
        return allNotes;
    }
    public void insert(Note note){
        repository.insert(note);
    }
    public void update(Note note){
        repository.updateNote(note);
    }
    public void delete(Note note){
        repository.deleteNote(note);
    }
    public void deleteAllNotes(){
        repository.deleteAllNotes();
    }
}


