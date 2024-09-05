package com.oc.medilabo.service;

import com.oc.medilabo.bean.Patient;
import com.oc.medilabo.bean.enums.Gender;
import com.oc.medilabo.exceptions.NotFoundException;
import com.oc.medilabo.model.RiskLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Period;

@Service
public class RiskReportService {
    @Autowired
    NoteProxy noteProxy;
    @Autowired
    PatientProxy patientProxy;

    public int calculateAge(LocalDate birthdate) {
        if (birthdate == null) {
            return 0;
        }
        LocalDate now = LocalDate.now();
        return Period.between(birthdate, now).getYears();
    }

    public RiskLevel getRiskLevel(BigInteger id) {
        Patient patient = patientProxy.fetchPatientWithPatientId(id)
                .orElseThrow(() -> new NotFoundException("The patient with id " + id + " doesn't exist"));

        int numberOfSymptoms = noteProxy.fetchSymptoms(id).size();
        int age = calculateAge(patient.getBirthDate());
        Gender gender = patient.getGender();

        if (numberOfSymptoms < 2) {
            return RiskLevel.None;
        } else if (age >= 30) {
            if (numberOfSymptoms <= 5) {
                return RiskLevel.Borderline;
            } else if (numberOfSymptoms <= 7) {
                return RiskLevel.In_Danger;
            }
        } else {
            if (
                (gender.equals(Gender.M) && numberOfSymptoms == 3) ||
                    (gender.equals(Gender.F) && numberOfSymptoms == 4)
            ) {
                return RiskLevel.In_Danger;
            } else if (
                (gender.equals(Gender.M) && numberOfSymptoms >= 5) ||
                    (gender.equals(Gender.F) && numberOfSymptoms >= 7)
            ) {
                return RiskLevel.Early_Onset;
            }
        }
        if (numberOfSymptoms >= 8) {
            return RiskLevel.Early_Onset;
        }

        return RiskLevel.None;
    }
}
