package com.emlakjet.advertiseservice.service;

import com.emlakjet.advertiseservice.repository.AdvertiseRepository;
import org.springframework.stereotype.Service;

@Service
public class AdvertiseServiceImpl {

    private final AdvertiseRepository advertiseRepository;

    public AdvertiseServiceImpl(AdvertiseRepository advertiseRepository) {
        this.advertiseRepository = advertiseRepository;
    }
}
