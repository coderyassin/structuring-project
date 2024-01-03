package org.yascode.structuringproject.web.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

public class URIFilter extends OncePerRequestFilter {

    protected final Log logger = LogFactory.getLog(this.getClass());
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logger.info("ExampleFilter");
        String requestURI = request.getRequestURI();
        if(Objects.equals("/api/v1/notes/api/v1/note-with-category-auth", requestURI)) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("You are not authorized.");
            return;
        }
        response.setHeader("URI", requestURI);

        filterChain.doFilter(request, response);
    }
}
