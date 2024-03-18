package org.cortesrmzcau.webclient.component;

import org.apache.logging.log4j.ThreadContext;
import org.cortesrmzcau.webclient.exceptions.ErrorResponse;
import org.cortesrmzcau.webclient.exceptions.SuccessResponse;
import org.cortesrmzcau.webclient.utils.CodeMessage;
import org.springframework.http.HttpStatus;

import java.util.List;

public class TypeResponseComponent {
    protected SuccessResponse getSuccessResponse(HttpStatus status, Object body) {
        SuccessResponse response = new SuccessResponse();
        response.setMessage(CodeMessage.message(status));
        String folio = ThreadContext.get("Folio");
        if (folio != null) {
            response.setTrace(folio);
        }
        else {
            response.setTrace(String.valueOf(System.currentTimeMillis()));
        }
        response.setResult(body);
        return response;
    }

    public ErrorResponse getErrorResponse(
            HttpStatus httpStatus, List<String> details,String developer) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(CodeMessage.message(httpStatus));
        errorResponse.setTrace(String.valueOf(System.currentTimeMillis()));
        errorResponse.setInfo(developer);
        errorResponse.setDetails(details);
        return errorResponse;
    }
}
