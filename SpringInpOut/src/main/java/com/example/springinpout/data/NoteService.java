package com.example.springinpout.data;

import com.example.springinpout.model.Note;

import java.util.List;

public interface NoteService {

    Note save(Note note);

    List<Note> getAll();

    Note deleteNote(String title);
}
