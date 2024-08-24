package com.oc.medilabosolutions.services;

import com.oc.medilabosolutions.exceptions.IncorrectFormat;
import com.oc.medilabosolutions.exceptions.NotFoundException;
import com.oc.medilabosolutions.model.Patient;
import com.oc.medilabosolutions.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    public Patient findById(String id) {
        return patientRepository.findById(new BigInteger(id)).orElseThrow(() -> new NotFoundException("Patient doesn't exist"));
    }

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Patient patient, String id) {
        Patient existingPatient = patientRepository.findById(new BigInteger(id)).orElseThrow(() -> new NotFoundException("Patient not found."));

        existingPatient.setLastName(patient.getLastName() == null ? existingPatient.getLastName() : patient.getLastName());
        existingPatient.setFirstName(patient.getFirstName() == null ? existingPatient.getFirstName() : patient.getFirstName());
        existingPatient.setPhoneNumber(patient.getPhoneNumber() == null ? existingPatient.getPhoneNumber() : patient.getPhoneNumber());
        existingPatient.setPostalAddress(patient.getPostalAddress() == null ? existingPatient.getPostalAddress() : patient.getPostalAddress());

        return patientRepository.save(existingPatient);
    }
}
