package com.example.springinpout.controller;

import com.example.springinpout.data.NoteServiceImpl;
import com.example.springinpout.model.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    @Autowired
    NoteServiceImpl noteService;

    @GetMapping
    public String getNotes(Model model){
        model.addAttribute("noteList", noteService.getAll());
        return "notes";
    }
    // TODO: implement controller methods according to the javadoc and verify your impl using NoteControllerTest

    @PostMapping
    public String addNote(Note note){
        noteService.save(note);
        return "redirect:/notes";
    }

    @DeleteMapping
    public String deleteNote(Note note){
        noteService.deleteNote(note.getTitle());
        return "redirect:/notes";
    }
}
