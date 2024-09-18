package com.oc.medilabo.proxy;

import com.oc.medilabo.bean.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.math.BigInteger;
import java.util.List;

@FeignClient(name = "patients", url = "${gateway.url}" + "/patients")
public interface PatientProxy {
    @GetMapping()
    List<Patient> getAllPatients();

    @GetMapping("/{id}")
    Patient getPatientById(@PathVariable BigInteger id);

    @PostMapping()
    Patient createNewPatient(Patient patient);

    @PutMapping("/{id}")
    Patient updatePatient(@PathVariable BigInteger id, Patient patient);
}
