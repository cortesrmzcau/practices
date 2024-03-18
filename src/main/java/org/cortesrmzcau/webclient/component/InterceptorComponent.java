package org.cortesrmzcau.webclient.component;

import org.cortesrmzcau.webclient.service.ITraceService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.text.ParseException;

@Component
public class InterceptorComponent implements HandlerInterceptor {
    private final ITraceService traceService;

    public InterceptorComponent(ITraceService traceService) {
        this.traceService = traceService;
    }

    /*
     * Prehandle es llamado despues de que el controllador es llamado
     */
    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler) {
        traceService.registerIniTime(request);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws ParseException {
        traceService.registerTrace(request, response);
    }
}
