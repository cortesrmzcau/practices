package org.cortesrmzcau.webclient.utils;

import org.springframework.http.HttpStatus;

public final class CodeMessage {
  private CodeMessage() {

  }
  public static String message(HttpStatus httpStatus) {
      return switch (httpStatus) {
          case OK -> Constants.MSG_OPERACION_EXITOSA;
          case NOT_FOUND -> Constants.MSG_RECURSO_NO_ENCONTRADO;
          case BAD_REQUEST -> Constants.MSG_SOLICITUD_INVALIDA;
          default -> Constants.MSG_ERROR_INTERNO_DEL_SERVIDOR;
      };
  }
}
