package com.emlakjet.reportservice.utils;

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
        UserContextHolder.getContext().setAccess_token(httpServletRequest.getHeader(UserContext.AUTH_TOKEN));
        logger.info("User Service Incoming Correlation id: {} | Auth Token : {}",
                UserContextHolder.getContext().getCorrelation_id(),
                UserContextHolder.getContext().getAccess_token()
        );
        filterChain.doFilter(httpServletRequest,servletResponse);
    }
}
