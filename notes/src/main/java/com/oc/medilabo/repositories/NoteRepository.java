package com.oc.medilabo.repositories;

import com.oc.medilabo.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {
    List<Note> findAllByPatientIdOrderByCreatedAt(BigInteger patientId);

    @Query(value = "{'patientId': ?0, 'content': {$regex: ?1, $options: 'i'}}")
    List<Note> findNotesByPatientAndSymptom(BigInteger patientId, String symptom);
}
