package org.cortesrmzcau.webclient.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.UUID;

/*
 * @author    cortesrmzcau
 * @project   webclient-api-platzi
 * @resume    class with the exceptions for implement
 * @version   1.0.0
 * @since     17
 */
@ControllerAdvice
public class ResponseStandard extends RuntimeException {
  public ResponseEntity<Object> responseSuccess(HttpStatus httpStatus, Object message) {
      return ResponseEntity
              .status(httpStatus)
              .body(new StructureResponseSuccess(
                      UUID.randomUUID().toString(),
                      "Success operation",
                      message));
  }

  public ResponseEntity<Object> reponseNotFound(HttpStatus httpStatus, Object message) {
      return ResponseEntity
              .status(httpStatus)
              .body(new StructureResponseSuccess(
                      UUID.randomUUID().toString(),
                      "Invalid request",
                      message));
  }
  public ResponseEntity<Object> responseErrorInternalServer(HttpStatus httpStatus, Object message) {
      return ResponseEntity
              .status(httpStatus)
              .body(new StructureResponseSuccess(
                      UUID.randomUUID().toString(),
                      "Error Server Internal",
                      message));
  }
}
