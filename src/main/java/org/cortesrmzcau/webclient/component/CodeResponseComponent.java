package org.cortesrmzcau.webclient.component;

import lombok.extern.log4j.Log4j2;
import org.cortesrmzcau.webclient.configurations.exceptions.HttpProperties;
import org.cortesrmzcau.webclient.exceptions.CommonResponse;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Log4j2
@EnableConfigurationProperties(HttpProperties.class)
public class CodeResponseComponent {
    private final HttpProperties httpProperties;
    public CodeResponseComponent(HttpProperties httpProperties) {
        this.httpProperties = httpProperties;
    }

    public ResponseEntity<Object> responseEntity(HttpStatus httpStatus, Object body, List<String> details) {
        CommonResponse commonResponse;
        TypeResponseComponent typeResponseComponent = new TypeResponseComponent();
        if (httpStatus.is2xxSuccessful()) {
            commonResponse = typeResponseComponent.getSuccessResponse(httpStatus, body);
            return new ResponseEntity<>(commonResponse, httpStatus);
        }
        else {
            commonResponse = typeResponseComponent.getErrorResponse(
                    httpStatus, details, httpProperties.getDeveloper());
        }
        return new ResponseEntity<>(commonResponse, httpStatus);
    }
}
