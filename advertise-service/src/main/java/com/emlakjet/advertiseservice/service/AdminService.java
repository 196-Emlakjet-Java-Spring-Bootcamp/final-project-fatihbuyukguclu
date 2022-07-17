package com.emlakjet.advertiseservice.service;

import com.emlakjet.advertiseservice.model.Advertise;
import com.emlakjet.advertiseservice.model.AdvertiseState;
import com.emlakjet.advertiseservice.repository.AdvertiseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final AdvertiseRepository advertiseRepository;

    public AdminService(AdvertiseRepository advertiseRepository) {
        this.advertiseRepository = advertiseRepository;
    }

    public List<Advertise> getAllAdvertise() {

        List<Advertise> advertiseList = advertiseRepository.findAll();

        return advertiseList;
    }

    public Advertise approveAdvertise(String advertId) {
        Optional<Advertise> optionalAdvertise = advertiseRepository.findById(Long.valueOf(advertId));
        if (optionalAdvertise.isEmpty()){
            return null;
        }
        Advertise advertise = optionalAdvertise.get();
        advertise.setState(AdvertiseState.APPROVED);

        advertiseRepository.save(advertise);

        return advertise;
    }

    public Advertise rejectAdvertise(String advertId) {
        Optional<Advertise> optionalAdvertise = advertiseRepository.findById(Long.valueOf(advertId));

        if (optionalAdvertise.isEmpty()){
            return null;
        }
        Advertise advertise = optionalAdvertise.get();
        advertise.setState(AdvertiseState.REJECTED);

        advertiseRepository.save(advertise);

        return advertise;
    }
}
