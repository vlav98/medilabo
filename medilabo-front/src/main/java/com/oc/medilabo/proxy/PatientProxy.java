package com.oc.medilabo.proxy;

import com.oc.medilabo.bean.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "medilabo-patient", url = "localhost:8080")
public interface PatientProxy {
    @GetMapping("/patients")
    public List<Patient> getAllPatients();

    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable int id);

    @PostMapping("/patients")
    public Patient createNewPatient(Patient patient);

    @PostMapping("/patients/{id}")
    public Patient updatePatient(@PathVariable int id, Patient patient);
}
