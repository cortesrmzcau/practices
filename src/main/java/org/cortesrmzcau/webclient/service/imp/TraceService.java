package org.cortesrmzcau.webclient.service.imp;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.cortesrmzcau.webclient.exceptions.CommonResponse;
import org.cortesrmzcau.webclient.models.request.InfoRequest;
import org.cortesrmzcau.webclient.service.ITraceService;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Log4j2
public class TraceService implements ITraceService {
    InfoRequest infoRequest = InfoRequest.getInstance();
    @Override
    public void registerIniTime(HttpServletRequest httpServletRequest) {
        log.info("Request received at: " + dateToString());
        infoRequest.setTimeInitial(dateToString());

        //commonResponse.setInitialTime(dateToString());
        /*if (!httpServletRequest.getParameterMap().isEmpty()) {
            log.info(formatParameters(httpServletRequest.getParameterMap()));
        }
        log.info(formatParameters(httpServletRequest.getParameterMap()));*/
    }

    @Override
    public void registerTrace(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        log.info("Response completed at: " + dateToString());
        infoRequest.setFinishTime(dateToString());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date fecha1 = simpleDateFormat.parse(infoRequest.getTimeInitial());
        Date fecha2 = simpleDateFormat.parse(infoRequest.getFinishTime());

        long diff = fecha2.getTime() - fecha1.getTime();
        log.info("Time response: " + diff + " ms");
        infoRequest.setTimeResponse(String.valueOf(diff));
    }

    private Map<String, Object> formatParameters(Map<String, String[]> requestParameters) {
        Map<String, Object> parameters = new HashMap<>();
        Map<String, Object> parametersIn = new HashMap<>();
        for (Map.Entry<String, String[]> entry : requestParameters.entrySet()) {
            parametersIn.put(entry.getKey(), entry.getValue()[0]);
        }
        parametersIn.put("", parameters);
        return parametersIn;
    }

    private String dateToString() {
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return simpleFormatter.format(new Date());
    }
}
