package org.cortesrmzcau.practices.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.UUID;

@ControllerAdvice
public class ResponseStandard extends RuntimeException {
  public ResponseEntity<Object> responseSuccess(HttpStatus httpStatus, Object message) {
      return ResponseEntity
              .status(httpStatus)
              .body(new StructureResponseSuccess(
                      UUID.randomUUID().toString(),
                      "Operación Exitosa",
                      message));
  }

  public ResponseEntity<Object> reponseNotFound(HttpStatus httpStatus, Object message) {
      return ResponseEntity
              .status(httpStatus)
              .body(new StructureResponseSuccess(
                      UUID.randomUUID().toString(),
                      "Operación Exitosa",
                      message));
  }
}
