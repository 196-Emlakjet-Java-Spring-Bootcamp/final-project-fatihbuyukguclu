package com.emlakjet.gatewayserver.filter;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;

@Component
public class FilterUtils {

    public static final String CORRELATION_ID = "correlation-id";

    // return correlationId if it has or null
    public String getCorrelationId(HttpHeaders headers){
        if (headers.get(CORRELATION_ID) != null){
            List<String> header = headers.get(CORRELATION_ID);
            return header.stream().findFirst().get();
        }
        return null;
    }

    // Add to Header new key,value via ServerWebExchange builder method
    public ServerWebExchange setRequestHeader(ServerWebExchange exchange, String name, String value){
        return exchange.mutate().request(
                exchange.getRequest().mutate()
                        .header(name,value)
                        .build()
                )
                .build();
    }

    public ServerWebExchange setCorrelationId(ServerWebExchange exchange, String correlationId){
        return this.setRequestHeader(exchange,CORRELATION_ID,correlationId);
    }
}
