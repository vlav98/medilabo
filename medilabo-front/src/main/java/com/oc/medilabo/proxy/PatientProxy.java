package com.oc.medilabo.proxy;

import com.oc.medilabo.bean.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigInteger;
import java.util.List;

@FeignClient(name = "medilabo-patient")
//@FeignClient(name = "medilabo-patient", url = "localhost:8080/patients")
//@FeignClient(name = "medilabo-patient", url = "http://gateway-service:8761/patients")
public interface PatientProxy {
    @GetMapping()
    List<Patient> getAllPatients();

    @GetMapping("/{id}")
    Patient getPatientById(@PathVariable BigInteger id);

    @PostMapping()
    Patient createNewPatient(Patient patient);

    @PostMapping("/{id}")
    Patient updatePatient(@PathVariable BigInteger id, Patient patient);
}
