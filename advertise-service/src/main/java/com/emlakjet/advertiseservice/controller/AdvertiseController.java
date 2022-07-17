package com.emlakjet.advertiseservice.controller;

import com.emlakjet.advertiseservice.model.Advertise;
import com.emlakjet.advertiseservice.service.AdvertiseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/advertises")
public class AdvertiseController {

    private final AdvertiseService advertiseService;

    public AdvertiseController(AdvertiseService advertiseService) {
        this.advertiseService = advertiseService;
    }

    @PostMapping("/create/{userId}")
    public ResponseEntity<?> createAdvertise(@RequestBody Advertise advertise, @PathVariable String userId){
        advertiseService.createAdvertise(advertise,userId);
        return ResponseEntity.status(HttpStatus.CREATED).body("created");
    }

    @PutMapping("/update/{advertiseId}")
    public ResponseEntity<?> updateAdvertise(@RequestBody Advertise advertise, @PathVariable String advertiseId){
        advertiseService.updateAdvertise(advertise,advertiseId);
        return ResponseEntity.status(HttpStatus.OK).body("updated");
    }

    @DeleteMapping("/delete/{advertiseId}")
    public ResponseEntity<?> deleteAdvertise(@RequestBody Advertise advertise, @PathVariable String advertiseId){
        advertiseService.deleteAdvertise(advertise,advertiseId);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }



    @GetMapping("/hello")
    public ResponseEntity<?> hello(){
        return ResponseEntity.ok("Hello");
    }

}
