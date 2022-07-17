package com.example.adminservice.service;

import com.example.adminservice.model.Advertise;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class AdminService {

    private static final String BASE_URL = "http://ADVERTISE-SERVICE:8082";
    private final RestTemplate restTemplate;

    public AdminService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Advertise> getAllAdvertise() {

        ResponseEntity<Advertise[]> restExchange =
                restTemplate.getForEntity(
                        BASE_URL + "/api/v1/admin",
                        Advertise[].class
                );

        return Arrays.asList(restExchange.getBody());
    }

}
