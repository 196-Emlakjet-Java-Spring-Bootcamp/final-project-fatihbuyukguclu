package com.emlakjet.advertiseservice.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
//Incoming request into the service and map the correlation ID from request to the UserContext class.
public class UserContextFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(UserContextFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest  = (HttpServletRequest) servletRequest;
        UserContextHolder.getContext().setCorrelation_id(httpServletRequest.getHeader(UserContext.CORRELATION_ID));
        logger.debug("User Service Incoming Correlation id: {}",UserContextHolder.getContext().getCorrelation_id());
        filterChain.doFilter(httpServletRequest,servletResponse);
    }
}
