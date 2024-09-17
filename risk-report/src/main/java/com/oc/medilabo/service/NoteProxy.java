package com.oc.medilabo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoteProxy {
    String baseURL = "http://192.168.1.95:9000/notes/";
    private final RestTemplate restTemplate;

    public NoteProxy(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List fetchSymptoms(BigInteger id) {
        String endURL = id + "/symptoms";
        String url = baseURL + endURL;
        try {
            ResponseEntity<List> responseEntity = restTemplate.getForEntity(url, List.class);
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                return responseEntity.getBody();
            } else {
                return new ArrayList<>();
            }
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
