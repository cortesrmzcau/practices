package org.cortesrmzcau.webclient.utils;

/*
 * @author    cortesrmzcau
 * @project   webclient-api-platzi
 * @resume    constants to implement
 * @version   1.0.0
 * @since     17
 */
public final class Constants {
  public static final String VERSION = "v1";

  // Tipos de peticiones Http
  public static final String GET = "GET"; // Obtener
  public static final String POST = "POST"; // Enviar
  public static final String PUT = "PUT"; // Actualizar
  public static final String DELETE = "DELETE"; // Eliminar

  // Codigos de respuesta Http
  public static final int X200 = 200; // Peticion correcta
  public static final int X201 = 201; // Registro correcto
  public static final int X400 = 400; // Peticion incorrecta
  public static final int X401 = 401; // No autorizado
  public static final int X404 = 404; // No encontrado
  public static final int X500 = 500; // Error interno del servidor

  // Mensajes de los codigos de respuesta
  public static final String MSG_OPERACION_EXITOSA = "Operation successful.";
  public static final String MSG_SOLICITUD_INVALIDA = "Invalid Request.";
  public static final String MSG_ACCESO_NO_AUTORIZADO = "Unauthorized access.";
  public static final String MSG_PERMISO_INVALIDO = "Invalid Permit.";
  public static final String MSG_RECURSO_NO_ENCONTRADO = "Resource not found.";
  public static final String MSG_ERROR_INTERNO_DEL_SERVIDOR = "Error internal server.";

  private Constants() { // Evitamos que se creen instancias de la clase desde fuera de la clase
    throw new IllegalArgumentException("IllegalArgumentException Constants");
  }
}
