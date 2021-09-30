package com.example.keepnotes;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class NoteDatabase extends RoomDatabase {
      public abstract NoteDao noteDao();
      public static NoteDatabase INSTANCE;
      private static final int NUMBER_OF_THREADS = 4;
      static final ExecutorService databaseWriteExecutor =
              Executors.newFixedThreadPool(NUMBER_OF_THREADS);

      public static NoteDatabase getInstance(Context context){
          if(INSTANCE==null){
              INSTANCE= Room.databaseBuilder(context.getApplicationContext(),
                      NoteDatabase.class,
                      "word_db")
                      .build();
          }
          return INSTANCE;
      }

  }
