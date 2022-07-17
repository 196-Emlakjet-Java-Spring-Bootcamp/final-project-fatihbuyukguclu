package com.emlakjet.gatewayserver.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class TrackingFilter implements GlobalFilter {

    private static final Logger logger = LoggerFactory.getLogger(TrackingFilter.class);

    @Autowired
    FilterUtils filterUtils;

    @Override
    // Code that executes everytime when a request passes through filter
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders requestHeader = exchange.getRequest().getHeaders(); // HTTP header from request

        if (isCorrelationIdPresent(requestHeader)){
            logger.debug("correlation_id found in trackingfilter: {}",filterUtils.getCorrelationId(requestHeader));
        }else{
            String correlationId =  generateCorrelationId(); // if correlation_id not found in header, generate one
            exchange = filterUtils.setCorrelationId(exchange,correlationId);
            logger.debug("correlation_id generated in tracking filter: {}",correlationId);
        }
        return chain.filter(exchange);
    }

    private boolean isAuthTokenPresent(HttpHeaders header){
        return filterUtils.getAuthToken(header) != null;
    }


    private boolean isCorrelationIdPresent(HttpHeaders header){
        return filterUtils.getCorrelationId(header) != null;
    }

    private String generateCorrelationId() {
        return UUID.randomUUID().toString();
    }

}
