package com.example.adminservice.service;

import com.example.adminservice.model.Advertise;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class AdminService {

    private static final String BASE_URL = "http://ADVERTISE-SERVICE:8082/api/v1/admin";
    private final RestTemplate restTemplate;

    public AdminService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Advertise> getAllAdvertise() {

        ResponseEntity<Advertise[]> restExchange =
                restTemplate.getForEntity(
                        BASE_URL,
                        Advertise[].class
                );

        return Arrays.asList(restExchange.getBody());
    }

    public ResponseEntity<?> approveAdvertise(String advertId) {

        return restTemplate.getForEntity(
                BASE_URL + "/advertises/{advertId}/approve",
                String.class,
                advertId
        );
    }

    public ResponseEntity<?> rejectAdvertise(String advertId) {

        return restTemplate.getForEntity(
                BASE_URL + "/advertises/{advertId}/reject",
                String.class,
                advertId
        );
    }
}
