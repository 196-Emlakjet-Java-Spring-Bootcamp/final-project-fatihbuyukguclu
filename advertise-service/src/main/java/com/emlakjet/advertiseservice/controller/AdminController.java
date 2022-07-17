package com.emlakjet.advertiseservice.controller;

import com.emlakjet.advertiseservice.model.Advertise;
import com.emlakjet.advertiseservice.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public ResponseEntity<List<Advertise>> getAllAdvertise(){
        return ResponseEntity.ok(adminService.getAllAdvertise());
    }


    @GetMapping("/advertises/{advertId}/approve")
    public ResponseEntity<?> approveAdvertise(@PathVariable String advertId){
        Advertise advertise = null;
        try{
            advertise = adminService.approveAdvertise(advertId);
        }catch (Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.ok("Approved");
    }

    @GetMapping("/advertises/{advertId}/reject")
    public ResponseEntity<?> rejectAdvertise(@PathVariable String advertId){
        Advertise advertise = null;
        try{
            advertise = adminService.rejectAdvertise(advertId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.ok("Rejected");
    }

}
