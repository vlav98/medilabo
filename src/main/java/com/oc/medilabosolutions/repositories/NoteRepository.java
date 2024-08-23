package com.oc.medilabosolutions.repositories;

import com.oc.medilabosolutions.model.Note;
import com.oc.medilabosolutions.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, BigInteger> {
    List<Note> findAllByPatientOrderByAddedAt(Patient patient);
}
