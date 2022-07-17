package com.emlakjet.reportservice.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter@Setter
//POJO class that holds HTTP headers value
public class UserContext {
    public static final String CORRELATION_ID = "correlation_id";
    public static final String AUTH_TOKEN = "Authorization";

    private String correlation_id;
    private String access_token;

}
