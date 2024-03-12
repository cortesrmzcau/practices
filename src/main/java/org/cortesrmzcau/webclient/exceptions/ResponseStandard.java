package org.cortesrmzcau.webclient.exceptions;

import org.cortesrmzcau.webclient.utils.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.List;
import java.util.UUID;

/*
 * @author    cortesrmzcau
 * @project   webclient-api-platzi
 * @resume    control of exceptions for implement
 * @version   1.0.0
 * @since     17
 */
@ControllerAdvice
public class ResponseStandard extends RuntimeException {
  public ResponseEntity<Object> responseSuccess(HttpStatus httpStatus, Object result) {
      if (result == null) {
          return ResponseEntity
                  .status(httpStatus)
                  .body(new SuccessResponse(
                          UUID.randomUUID().toString(),
                          "Success operation"));
      }
      else {
          {
          return ResponseEntity
                  .status(httpStatus)
                  .body(new SuccessResultResponse(
                          UUID.randomUUID().toString(),
                          "Success operation.",
                          result));
      }
    }
  }

  public ResponseEntity<Object> reponseNotFound(HttpStatus httpStatus, List<String> result) {
      return ResponseEntity
              .status(httpStatus)
              .body(new ErrorResponse(
                      Constants.X404,
                      "Invalid request.",
                      UUID.randomUUID().toString(),
                      "https://github.com/cortesrmzcau",
                      result));
  }

  public ResponseEntity<Object> responseErrorInternalServer(HttpStatus httpStatus, List<String> result) {
      return ResponseEntity
              .status(httpStatus)
              .body(new ErrorResponse(
                      Constants.X500,
                      "Error Server Internal.",
                      UUID.randomUUID().toString(),
                      "https://github.com/cortesrmzcau",
                      result));
  }
}
