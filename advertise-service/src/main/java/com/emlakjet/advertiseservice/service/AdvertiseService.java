package com.emlakjet.advertiseservice.service;

import com.emlakjet.advertiseservice.model.Advertise;
import com.emlakjet.advertiseservice.repository.AdvertiseRepository;
import org.springframework.stereotype.Service;


public interface AdvertiseService {

    void createAdvertise(Advertise advertise, String userId);

    void updateAdvertise(Advertise advertise, String advertiseId);

    void deleteAdvertise(Advertise advertise, String advertiseId);
}
