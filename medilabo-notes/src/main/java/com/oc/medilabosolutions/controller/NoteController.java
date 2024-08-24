package com.oc.medilabosolutions.controller;

import com.oc.medilabosolutions.model.Note;
import com.oc.medilabosolutions.services.NoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
    private final Logger logger = LoggerFactory.getLogger(NoteController.class);

    @Autowired
    private NoteService noteService;

    @GetMapping("/all")
    public ResponseEntity<List<Note>> getAll() {
        return ResponseEntity.ok(noteService.getAllNotes());
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<List<Note>> getNoteHistoryForPatient(@PathVariable BigInteger patientId) {
        logger.info("Getting all notes for patient " + patientId);
        List<Note> noteHistoryByPatient = noteService.getNoteHistoryByPatient(patientId);
        return ResponseEntity.ok(noteHistoryByPatient);
    }

    @PostMapping()
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        logger.info("Adding new note for patient " + note.getPatient());
        return new ResponseEntity<>(noteService.addNewNote(note), HttpStatus.CREATED);
    }

}
