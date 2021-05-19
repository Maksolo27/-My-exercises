package com.example.springinpout.data;


import com.example.springinpout.model.Note;
import com.example.springinpout.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    NoteRepository noteRepository;

    @Override
    public Note save(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note deleteNote(String title) {
        return noteRepository.deleteNoteByTitle(title);
    }










/*    private final Map<UUID, Note> notesMap = new HashMap<>();

    public List<Note> getAll(){
        ArrayList<Note> noteList = new ArrayList<>(notesMap.values());
        noteList.sort(Comparator.comparing(Note::getCreatedOn));
        return noteList;
    }

    public void add(Note note) {
        note.setId(UUID.randomUUID());
        note.setCreatedOn(LocalDateTime.now());
        notesMap.put(note.getId(), note);
    }*/
}