package com.docker.challenge.challenge1;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

/**
 * @author Hadi Zahedian
 * @since 2/6/2023
 */
@Component
public class Challenge1LogFilter extends GenericFilterBean {

    private final Log logger = LogFactory.getLog(getClass());

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            String message = "Status: " + response.getStatus() + " - Request: " + request.getRequestURL();
            if (request.getQueryString() != null) {
                message += "?" + request.getQueryString();
            }

            logger.info(message);
        }
    }
}
