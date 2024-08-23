package com.oc.medilabosolutions.services;

import com.oc.medilabosolutions.exceptions.NotFoundException;
import com.oc.medilabosolutions.model.Note;
import com.oc.medilabosolutions.model.Patient;
import com.oc.medilabosolutions.repositories.NoteRepository;
import com.oc.medilabosolutions.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private PatientRepository patientRepository;


    public List<Note> getNoteHistoryByPatient(BigInteger patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(
                () -> new NotFoundException("Patient doesn't exist")
        );
        return noteRepository.findAllByPatientOrderByAddedAt(patient);
    }

    public Note addNewNote(BigInteger patientId, Note note) {
        note.setPatient(patientRepository.findById(patientId).orElseThrow(
                () -> new NotFoundException("Patient doesn't exist")
        ));
        note.setAddedAt(LocalDate.now());
        return noteRepository.save(note);
    }

}
