package com.emlakjet.userservice.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter@Setter
@Builder
public class KeycloakUser {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
