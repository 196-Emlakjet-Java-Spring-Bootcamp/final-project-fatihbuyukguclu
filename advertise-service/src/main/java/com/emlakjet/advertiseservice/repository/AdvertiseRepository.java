package com.emlakjet.advertiseservice.repository;

import com.emlakjet.advertiseservice.model.Advertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertiseRepository extends JpaRepository<Advertise, Long> {
}
