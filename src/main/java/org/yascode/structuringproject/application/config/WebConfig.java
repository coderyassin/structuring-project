package org.yascode.structuringproject.application.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.yascode.structuringproject.web.filter.CorrelationIdFilter;
import org.yascode.structuringproject.web.filter.URIFilter;

import static org.yascode.structuringproject.application.util.FilterOrder.O1;
import static org.yascode.structuringproject.application.util.FilterOrder.O2;

@Configuration
public class WebConfig {

    protected final Log logger = LogFactory.getLog(this.getClass());

    @Bean
    public FilterRegistrationBean<CorrelationIdFilter> correlationIdFilter() {
        FilterRegistrationBean<CorrelationIdFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new CorrelationIdFilter());
        registrationBean.addUrlPatterns("/api/*");
        registrationBean.setOrder(O1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<URIFilter> URIFilter() {
        FilterRegistrationBean<URIFilter> registrationBean =
                new FilterRegistrationBean<>();
        registrationBean.setFilter(new URIFilter());
        registrationBean.addUrlPatterns("/api/*");
        registrationBean.setOrder(O2);
        return registrationBean;
    }



}
