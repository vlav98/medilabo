package com.oc.medilabo.controller;

import com.oc.medilabo.model.Patient;
import com.oc.medilabo.services.PatientService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final Logger logger = LoggerFactory.getLogger(PatientController.class);

    @Autowired
    private PatientService patientService;

    @GetMapping
    public ResponseEntity<List<Patient>> getAll() {
        List<Patient> patientList = patientService.findAllPatients();
        logger.info(patientList.toString());
        return ResponseEntity.ok(patientList);
    }

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody @Valid Patient patient) {
        logger.info(patient.toString());
        return new ResponseEntity<>(patientService.createPatient(patient), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable BigInteger id) {
        return ResponseEntity.ok(patientService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable BigInteger id, @RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.updatePatient(patient, id));
    }

}
