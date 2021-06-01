package com.example.application.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.vaadin.flow.spring.security.VaadinDefaultRequestCache;

/**
 * HttpSessionRequestCache that avoids saving internal framework requests.
 */
@Component
class CustomRequestCache extends VaadinDefaultRequestCache {
    /**
     * {@inheritDoc}
     *
     * If the method is considered an internal request from the framework, we
     * skip saving it.
     *
     * @see SecurityUtils#isFrameworkInternalRequest(HttpServletRequest)
     */
    @Override
    public void saveRequest(HttpServletRequest request,
            HttpServletResponse response) {
        if (request.getServletPath().startsWith("/beacon/")) {
            return;
        }
        super.saveRequest(request, response);
    }

}
