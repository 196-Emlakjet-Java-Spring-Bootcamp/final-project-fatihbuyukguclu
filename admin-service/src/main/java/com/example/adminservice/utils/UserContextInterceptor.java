package com.example.adminservice.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
//Injects the correlation ID into any
// outgoing service request that executed RestTemplate
public class UserContextInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {

        HttpHeaders httpHeaders = request.getHeaders();
        httpHeaders.add(UserContext.CORRELATION_ID, UserContextHolder.getContext().getCorrelation_id());
        httpHeaders.add(UserContext.AUTH_TOKEN, UserContextHolder.getContext().getAccess_token());

        return execution.execute(request, body);
    }
}
