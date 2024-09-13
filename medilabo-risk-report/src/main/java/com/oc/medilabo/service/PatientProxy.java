package com.oc.medilabo.service;

import com.oc.medilabo.bean.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class PatientProxy {
    private static final Logger logger = LogManager.getLogger(PatientProxy.class);
    String baseURL = "http://localhost:8090/patients/";

    private final RestTemplate restTemplate;

    public PatientProxy(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Optional<Patient> fetchPatientWithPatientId(BigInteger id) {
        String url = baseURL + id;
        try {
            ResponseEntity<Patient> responseEntity = restTemplate.getForEntity(url, Patient.class);
            logger.info(responseEntity.getStatusCode());
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                logger.info(responseEntity.getBody());
                return Optional.ofNullable(responseEntity.getBody());
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
