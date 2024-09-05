package com.oc.medilabo.controller;

import com.oc.medilabo.bean.Note;
import com.oc.medilabo.proxy.NoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NoteController {
    @Autowired
    public NoteProxy noteProxy;

    @PostMapping("/notes/add")
    public String addNewNote(Note newNote) {
        noteProxy.createNewNote(newNote);
        return "redirect:/patients/" + newNote.getPatientId();
    }
}
