package com.emlakjet.userservice.service;

import com.emlakjet.userservice.dto.KeycloakUser;
import com.emlakjet.userservice.model.User;
import com.emlakjet.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final KeycloakService keycloakService;

    public UserService(UserRepository userRepository, KeycloakService keycloakService) {
        this.userRepository = userRepository;
        this.keycloakService = keycloakService;
    }

    public String signUpUser(User user) {

        KeycloakUser keycloakUser = KeycloakUser.builder()
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .build();

        int status = keycloakService.createUserWithKeycloak(keycloakUser);

        userRepository.save(user);

        return "created";
    }
}
