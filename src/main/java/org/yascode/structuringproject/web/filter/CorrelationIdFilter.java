package org.yascode.structuringproject.web.filter;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.filter.OncePerRequestFilter;
import org.yascode.structuringproject.application.util.CorrelationIdGenerator;
import org.yascode.structuringproject.web.util.RequestCorrelation;

import java.io.IOException;

public class CorrelationIdFilter extends OncePerRequestFilter {

    protected final Log logger = LogFactory.getLog(this.getClass());

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        logger.info("CorrelationIdFilter");

        String currentCorrelationId = httpServletRequest.getHeader(RequestCorrelation.CORRELATION_ID);

        if (!currentRequestIsAsyncDispatcher(httpServletRequest)) {
            if (currentCorrelationId == null) {
                currentCorrelationId = CorrelationIdGenerator.generateCorrelationId();
                logger.info("No correlationId found in Header. Generated : " + currentCorrelationId);
                httpServletResponse.addHeader("Correlation-Id", currentCorrelationId);
            } else {
                logger.info("Found correlationId in Header : " + currentCorrelationId);
            }

            RequestCorrelation.setId(currentCorrelationId);
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private boolean currentRequestIsAsyncDispatcher(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getDispatcherType().equals(DispatcherType.ASYNC);
    }
}
