package org.cortesrmzcau.webclient.configurations.interceptor;

import org.cortesrmzcau.webclient.component.InterceptorComponent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Value("${spring.application.interceptor.enabled}")
    private boolean interceptorEnabled;
    private final InterceptorComponent interceptorComponent;

    public WebConfiguration(InterceptorComponent interceptorComponent) {
        this.interceptorComponent = interceptorComponent;
    }

    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        if (interceptorEnabled) {
            interceptorRegistry.addInterceptor(interceptorComponent);
        }
    }

}
