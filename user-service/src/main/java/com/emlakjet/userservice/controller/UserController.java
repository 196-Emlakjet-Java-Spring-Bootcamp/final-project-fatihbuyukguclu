package com.emlakjet.userservice.controller;

import com.emlakjet.userservice.dto.LoginRequest;
import com.emlakjet.userservice.model.User;
import com.emlakjet.userservice.service.KeycloakService;
import com.emlakjet.userservice.service.UserService;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;
    private final KeycloakService keycloakService;

    public UserController(UserService userService, KeycloakService keycloakService) {
        this.userService = userService;
        this.keycloakService = keycloakService;
    }


    @PostMapping("/register")
    public ResponseEntity<?> signUpUser(@RequestBody User user){
        return ResponseEntity.ok(userService.signUpUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<AccessTokenResponse> login(@RequestBody LoginRequest request){
        AccessTokenResponse accessTokenResponse =keycloakService.loginWithKeycloak(request);
        if (accessTokenResponse == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(accessTokenResponse);
        }
        return ResponseEntity.ok(accessTokenResponse);
    }

    @GetMapping()
    public ResponseEntity<?> helloController(){
        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("/advertise")
    public ResponseEntity<?> advertiseController(){
        RestTemplate restTemplate = new RestTemplate();


        return restTemplate.exchange("http://localhost:8082/hello", HttpMethod.GET,null,String.class);
    }
}
