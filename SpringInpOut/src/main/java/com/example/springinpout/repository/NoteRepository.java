package com.example.springinpout.repository;

import com.example.springinpout.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long>, CrudRepository<Note, Long> {

    Note deleteNoteByTitle(String string);
}
