package com.oc.medilabo.services;

import com.oc.medilabo.exceptions.NotFoundException;
import com.oc.medilabo.model.Patient;
import com.oc.medilabo.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    public Patient findById(BigInteger id) {
        return patientRepository.findById(id).orElseThrow(() -> new NotFoundException("Patient doesn't exist"));
    }

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Patient patient, BigInteger id) {
        Patient existingPatient = patientRepository.findById(id).orElseThrow(() -> new NotFoundException("Patient not found."));

        existingPatient.setLastName(patient.getLastName() == null ? existingPatient.getLastName() : patient.getLastName());
        existingPatient.setFirstName(patient.getFirstName() == null ? existingPatient.getFirstName() : patient.getFirstName());
        existingPatient.setPhoneNumber(patient.getPhoneNumber() == null ? existingPatient.getPhoneNumber() : patient.getPhoneNumber());
        existingPatient.setPostalAddress(patient.getPostalAddress() == null ? existingPatient.getPostalAddress() : patient.getPostalAddress());

        return patientRepository.save(existingPatient);
    }
}
