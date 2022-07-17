package com.emlakjet.advertiseservice.repository;

import com.emlakjet.advertiseservice.model.Advertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdvertiseRepository extends JpaRepository<Advertise, Long> {

    Optional<Advertise> findById(Long id);

}
