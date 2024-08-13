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
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate birthDateParsed = LocalDate.parse(patient.getBirthDate(), formatter);
            patient.setBirthDate(birthDateParsed.toString());
        } catch (DateTimeParseException e) {
            throw new IncorrectFormat("Invalid birth date format. Expected format: YYYY-MM-DD");
        }
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Patient patient, String id) {
        BigInteger parsedID = new BigInteger(id);
        Patient existingPatient = patientRepository.findById(parsedID).orElseThrow(() -> new NotFoundException("Patient not found."));

        existingPatient.setLastName(patient.getLastName());
        existingPatient.setFirstName(patient.getFirstName());
        existingPatient.setPhoneNumber(patient.getPhoneNumber());
        existingPatient.setPostalAddress(patient.getPostalAddress());

        return patientRepository.save(existingPatient);
    }
}
