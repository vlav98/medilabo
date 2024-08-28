package com.oc.medilabosolutions.repositories;

import com.oc.medilabosolutions.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface NoteRepository extends MongoRepository<Note, BigInteger> {
    List<Note> findAllByPatientIdOrderByCreatedAt(BigInteger patientId);

    public List<Note> findNotesByPatientIdOrderByCreatedAt(BigInteger patient);
}
