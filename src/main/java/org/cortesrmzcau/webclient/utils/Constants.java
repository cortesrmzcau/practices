package org.cortesrmzcau.webclient.utils;

/*
 * @author    cortesrmzcau
 * @project   webclient-api-platzi
 * @resume    class with the constants to implement
 * @version   1.0.0
 * @since     17
 */
public final class Constants {
  public static final String VERSION = "v1";
  public static final String GET = "GET";
  public static final String POST = "POST";
  public static final String PUT = "PUT";
  public static final String DELETE = "DELETE";

  private Constants() { // Evitamos que se creen instancias de la clase desde fuera de la clase
    throw new IllegalArgumentException("IllegalArgumentException Constants");
  }
}
