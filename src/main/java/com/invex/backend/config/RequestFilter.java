package com.invex.backend.config;

import java.io.IOException;
import java.util.Enumeration;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestFilter implements Filter{

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) req;

        Enumeration<String> headerNames = httpRequest.getHeaderNames();
        StringBuilder sb = new StringBuilder();
        sb.append("Headers of request:");
        while (headerNames.hasMoreElements()) {
            String headerName = (String) headerNames.nextElement();  
            String headerValue = httpRequest.getHeader(headerName);
            sb.append(headerName).append("=").append(headerValue).append(",");
        }
        
        log.info(sb.toString());
        chain.doFilter(req, res);
        
    }

}
