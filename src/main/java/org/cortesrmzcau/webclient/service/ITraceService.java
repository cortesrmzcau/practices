package org.cortesrmzcau.webclient.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.text.ParseException;

public interface ITraceService {
    void registerIniTime(HttpServletRequest httpServletRequest);
    void registerTrace(HttpServletRequest request, HttpServletResponse response) throws ParseException;
}
