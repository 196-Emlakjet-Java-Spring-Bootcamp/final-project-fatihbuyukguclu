package com.emlakjet.userservice.service;

import com.emlakjet.userservice.dto.KeycloakUser;
import com.emlakjet.userservice.dto.LoginRequest;
import com.emlakjet.userservice.model.User;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.AccessTokenResponse;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class KeycloakService {

    private static final Logger logger = LoggerFactory.getLogger(KeycloakService.class);

    //@Value("${keycloak.realm}")
    private String realm = "project-realm";

    private final Keycloak keycloak;


    public KeycloakService(Keycloak keycloak) {
        this.keycloak = keycloak;
    }


    public AccessTokenResponse loginWithKeycloak(LoginRequest request){
        Keycloak loginKeycloak = newKeycloakBuilder(request.getEmail(), request.getPassword());

        AccessTokenResponse accessTokenResponse = null;

        try{
            accessTokenResponse = loginKeycloak.tokenManager().getAccessToken();
            return accessTokenResponse;
        }catch (Exception e){
            return null;
        }
    }

    public int createUserWithKeycloak(KeycloakUser keycloakUser){

        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setFirstName(keycloakUser.getFirstName());
        userRepresentation.setLastName(keycloakUser.getLastName());
        userRepresentation.setEmail(keycloakUser.getEmail());
        userRepresentation.setUsername(keycloakUser.getEmail());
        userRepresentation.setRealmRoles(Collections.singletonList("project-user"));
        HashMap<String, List<String>> clientRoles = new HashMap<>();
        clientRoles.put("final-project",Collections.singletonList("USER"));
        userRepresentation.setClientRoles(clientRoles);

        userRepresentation.setEnabled(true);

        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
        credentialRepresentation.setType("password");
        credentialRepresentation.setValue(keycloakUser.getPassword());
        credentialRepresentation.setTemporary(false);


        userRepresentation.setCredentials(Collections.singletonList(credentialRepresentation));


        Response response = keycloak.realm(realm).users().create(userRepresentation);
        logger.info("Response |  Status: {} , INFO: {}", response.getStatus(),response.getStatusInfo());

        return response.getStatus();
    }

    private Keycloak newKeycloakBuilder(String username, String password){
        return KeycloakBuilder.builder()
                .realm(realm)
                .serverUrl("http://localhost:8080/auth")
                .clientId("final-project")
                .clientSecret("xXOXU2jgJVXbXUrlRtETFJWexiDiK0Xw")
                .username(username)
                .password(password)
                .build();
    }
}
