package com.emlakjet.userservice.controller;

import com.emlakjet.userservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
//@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RolesAllowed({ "ADMIN", "USER" })
    @GetMapping()
    public ResponseEntity<?> helloController(){
        return ResponseEntity.ok("Hello World");
    }
}
