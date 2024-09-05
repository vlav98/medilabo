package com.oc.medilabo;

import com.oc.medilabo.bean.Patient;
import com.oc.medilabo.bean.enums.Gender;
import com.oc.medilabo.exceptions.NotFoundException;
import com.oc.medilabo.model.RiskLevel;
import com.oc.medilabo.service.NoteProxy;
import com.oc.medilabo.service.PatientProxy;
import com.oc.medilabo.service.RiskReportService;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RiskReportServiceTests {
    @Autowired
    private RiskReportService riskReportService;
    @MockBean
    private NoteProxy noteProxy;
    @MockBean
    private PatientProxy patientProxy;

    private List<String> generateSymptoms(int nbOfSymptoms) {
        List<String> symptomsList = new ArrayList<>();
        for (int i = 0; i < nbOfSymptoms; i++) {
            symptomsList.add("Symptom" + i);
        }
        return symptomsList;
    }

    @Test
    public void calculateAgeToday() {
        assertEquals(riskReportService.calculateAge(null), 0);
    }

    @Test
    public void canNotGetPatient() {
        BigInteger id = BigInteger.valueOf(1);
        Mockito.when(patientProxy.fetchPatientWithPatientId(id))
                .thenThrow(new NotFoundException("The patient with id " + id + " doesn't exist"));

        assertThrows(Exception.class, () -> riskReportService.getRiskLevel(id));
    }

    @Test
    public void getPatientWithNoSymptomsRiskLevelNone() {
        BigInteger id = BigInteger.valueOf(1);
        Patient patient = new Patient();
        patient.setGender(Gender.M);
        Mockito.when(patientProxy.fetchPatientWithPatientId(id)).thenReturn(Optional.of(patient));
        Mockito.when(noteProxy.fetchSymptoms(id)).thenReturn(new ArrayList<>());

        assertEquals(RiskLevel.None, riskReportService.getRiskLevel(id));
    }

    @Test
    public void getPatientWithLessThan2SymptomsRiskLevelNone() {
        BigInteger id = BigInteger.valueOf(1);
        Patient patient = new Patient();
        patient.setGender(Gender.M);
        Mockito.when(patientProxy.fetchPatientWithPatientId(id)).thenReturn(Optional.of(patient));
        Mockito.when(noteProxy.fetchSymptoms(id)).thenReturn(generateSymptoms(1));

        assertEquals(RiskLevel.None, riskReportService.getRiskLevel(id));
    }

    @Test
    public void getPatientWith2SymptomsRiskLevelBorderline() {
        BigInteger id = BigInteger.valueOf(1);
        Patient patient = new Patient();
        patient.setBirthDate(LocalDate.of(1980, 1,1));
        patient.setGender(Gender.M);
        Mockito.when(patientProxy.fetchPatientWithPatientId(id)).thenReturn(Optional.of(patient));
        Mockito.when(noteProxy.fetchSymptoms(id)).thenReturn(generateSymptoms(2));

        assertEquals(RiskLevel.Borderline, riskReportService.getRiskLevel(id));
    }

    @Test
    public void getPatientWith5SymptomsRiskLevelBorderline() {
        BigInteger id = BigInteger.valueOf(1);
        Patient patient = new Patient();
        patient.setBirthDate(LocalDate.of(1980, 1,1));
        patient.setGender(Gender.M);
        Mockito.when(patientProxy.fetchPatientWithPatientId(id)).thenReturn(Optional.of(patient));
        Mockito.when(noteProxy.fetchSymptoms(id)).thenReturn(generateSymptoms(2));

        assertEquals(RiskLevel.Borderline, riskReportService.getRiskLevel(id));
    }

    @Test
    public void getMalePatientWith3SymptomsLess30YearsOldRiskLevelInDanger() {
        BigInteger id = BigInteger.valueOf(1);
        Patient patient = new Patient();
        patient.setBirthDate(LocalDate.of(2000, 1,1));
        patient.setGender(Gender.M);
        Mockito.when(patientProxy.fetchPatientWithPatientId(id)).thenReturn(Optional.of(patient));
        Mockito.when(noteProxy.fetchSymptoms(id)).thenReturn(generateSymptoms(3));

        assertEquals(RiskLevel.In_Danger, riskReportService.getRiskLevel(id));
    }

    @Test
    public void getFemalePatientWith4SymptomsLess30YearsOldRiskLevelInDanger() {
        BigInteger id = BigInteger.valueOf(1);
        Patient patient = new Patient();
        patient.setBirthDate(LocalDate.of(2000, 1,1));
        patient.setGender(Gender.F);
        Mockito.when(patientProxy.fetchPatientWithPatientId(id)).thenReturn(Optional.of(patient));
        Mockito.when(noteProxy.fetchSymptoms(id)).thenReturn(generateSymptoms(4));

        assertEquals(RiskLevel.In_Danger, riskReportService.getRiskLevel(id));
    }

    @Test
    public void getAnyPatientWith6SymptomsMore30YearsOldRiskLevelInDanger() {
        BigInteger id = BigInteger.valueOf(1);
        Patient patient = new Patient();
        patient.setBirthDate(LocalDate.of(1980, 1,1));
        patient.setGender(Gender.M);
        Mockito.when(patientProxy.fetchPatientWithPatientId(id)).thenReturn(Optional.of(patient));
        Mockito.when(noteProxy.fetchSymptoms(id)).thenReturn(generateSymptoms(6));

        assertEquals(RiskLevel.In_Danger, riskReportService.getRiskLevel(id));
    }

    @Test
    public void getAnyPatientWith7SymptomsMore30YearsOldRiskLevelInDanger() {
        BigInteger id = BigInteger.valueOf(1);
        Patient patient = new Patient();
        patient.setBirthDate(LocalDate.of(1980, 1,1));
        patient.setGender(Gender.F);
        Mockito.when(patientProxy.fetchPatientWithPatientId(id)).thenReturn(Optional.of(patient));
        Mockito.when(noteProxy.fetchSymptoms(id)).thenReturn(generateSymptoms(7));

        assertEquals(RiskLevel.In_Danger, riskReportService.getRiskLevel(id));
    }

    @Test
    public void getMalePatientWith5SymptomsLess30YearsOldRiskLevelEarlyOnset() {
        BigInteger id = BigInteger.valueOf(1);
        Patient patient = new Patient();
        patient.setBirthDate(LocalDate.of(2000, 1,1));
        patient.setGender(Gender.M);
        Mockito.when(patientProxy.fetchPatientWithPatientId(id)).thenReturn(Optional.of(patient));
        Mockito.when(noteProxy.fetchSymptoms(id)).thenReturn(generateSymptoms(5));

        assertEquals(RiskLevel.Early_Onset, riskReportService.getRiskLevel(id));
    }

    @Test
    public void getFemalePatientWith7SymptomsLess30YearsOldRiskLevelEarlyOnset() {
        BigInteger id = BigInteger.valueOf(1);
        Patient patient = new Patient();
        patient.setBirthDate(LocalDate.of(2000, 1,1));
        patient.setGender(Gender.F);
        Mockito.when(patientProxy.fetchPatientWithPatientId(id)).thenReturn(Optional.of(patient));
        Mockito.when(noteProxy.fetchSymptoms(id)).thenReturn(generateSymptoms(7));

        assertEquals(RiskLevel.Early_Onset, riskReportService.getRiskLevel(id));
    }

    @Test
    public void getAnyPatientWith8SymptomsMore30YearsOldRiskLevelEarlyOnset() {
        BigInteger id = BigInteger.valueOf(1);
        Patient patient = new Patient();
        patient.setBirthDate(LocalDate.of(1980, 1,1));
        patient.setGender(Gender.F);
        Mockito.when(patientProxy.fetchPatientWithPatientId(id)).thenReturn(Optional.of(patient));
        Mockito.when(noteProxy.fetchSymptoms(id)).thenReturn(generateSymptoms(8));

        assertEquals(RiskLevel.Early_Onset, riskReportService.getRiskLevel(id));
    }
}
