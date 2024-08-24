package com.oc.medilabosolutions.services;

import com.oc.medilabosolutions.model.Note;
import com.oc.medilabosolutions.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public List<Note> getNoteHistoryByPatient(BigInteger patient) {
        return noteRepository.findNotesByPatientIdOrderByCreatedAt(patient);
    }

    public Note addNewNote(Note note) {
        note.setCreatedAt(LocalDate.now());
        return noteRepository.save(note);
    }

}
