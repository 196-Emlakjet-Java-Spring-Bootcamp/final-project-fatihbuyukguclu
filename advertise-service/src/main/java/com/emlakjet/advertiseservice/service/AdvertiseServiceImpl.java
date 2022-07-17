package com.emlakjet.advertiseservice.service;

import com.emlakjet.advertiseservice.model.Advertise;
import com.emlakjet.advertiseservice.model.AdvertiseState;
import com.emlakjet.advertiseservice.repository.AdvertiseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdvertiseServiceImpl implements AdvertiseService{

    private final AdvertiseRepository advertiseRepository;

    public AdvertiseServiceImpl(AdvertiseRepository advertiseRepository) {
        this.advertiseRepository = advertiseRepository;
    }

    @Override
    public void createAdvertise(Advertise advertise, String userId) {
        advertise.setUserId(Long.valueOf(userId));
        advertise.setState(AdvertiseState.WAITING);
        advertiseRepository.save(advertise);
    }

    @Override
    public void updateAdvertise(Advertise advertise, String advertiseId) {
        Optional<Advertise> optionalAdvertise = advertiseRepository.findById(Long.valueOf(advertiseId));

        if (optionalAdvertise.isEmpty()){
            return;
        }
        Advertise fetchedAdvertise = optionalAdvertise.get();

        if (!fetchedAdvertise.getUserId().equals(advertise.getUserId())){
            return;
        }

        fetchedAdvertise.setState(AdvertiseState.WAITING);

        if (fetchedAdvertise.getPrice() != advertise.getPrice()){
            fetchedAdvertise.setPrice(advertise.getPrice());
        }
        if (fetchedAdvertise.getTitle() != advertise.getTitle()){
            fetchedAdvertise.setTitle(advertise.getTitle());
        }
        advertiseRepository.save(fetchedAdvertise);

    }

    @Override
    public void deleteAdvertise(Advertise advertise, String advertiseId) {
        Optional<Advertise> optionalAdvertise = advertiseRepository.findById(Long.valueOf(advertiseId));
        if (optionalAdvertise.isEmpty()){
            return;
        }
        Advertise fetchedAdvertise = optionalAdvertise.get();
        if (!fetchedAdvertise.getUserId().equals(advertise.getUserId())){
            return;
        }
        advertiseRepository.delete(advertise);
    }
}
