package com.oc.medilabosolutions.repositories;

import com.oc.medilabosolutions.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends MongoRepository<Patient, BigInteger> {
    public List<Patient> findPatientsByFirstNameAndLastName();
}
