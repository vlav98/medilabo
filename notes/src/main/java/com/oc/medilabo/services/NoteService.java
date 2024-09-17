package com.oc.medilabo.services;

import com.oc.medilabo.model.Note;
import com.oc.medilabo.model.Symptoms;
import com.oc.medilabo.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public List<Note> getNoteHistoryByPatient(BigInteger patientId) {
        return noteRepository.findAllByPatientIdOrderByCreatedAt(patientId);
    }

    public Note addNewNote(Note note) {
        note.setCreatedAt(LocalDate.now().atStartOfDay().toString());
        return noteRepository.save(note);
    }

    public List<String> getSymptomsFromPatientsNotes(BigInteger patientId) {
        List<String> symptoms = new ArrayList<>();

        for(Symptoms symptom: Symptoms.values()) {
            List<Note> notes = noteRepository.findNotesByPatientAndSymptom(patientId, symptom.toString());
            if (!notes.isEmpty()){
                symptoms.add(symptom.toString());
            }
        }

        return symptoms;
    }
}

