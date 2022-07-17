package com.example.adminservice.controller;

import com.example.adminservice.model.Advertise;
import com.example.adminservice.service.AdminService;
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

    @GetMapping("/advertises")
    public ResponseEntity<List<Advertise>> getAllAdvertise(){
        return ResponseEntity.ok(adminService.getAllAdvertise());
    }

    @GetMapping("/advertises/{advertId}/approve")
    public ResponseEntity<?> approveAdvertise(@PathVariable String advertId){

        return null;
    }

    @GetMapping("/advertises/{advertId}/reject")
    public ResponseEntity<?> rejectAdvertise(@PathVariable String advertId){

        return null;
    }

}
