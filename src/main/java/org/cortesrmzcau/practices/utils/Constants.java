package org.cortesrmzcau.practices.utils;

public final class Constants { // Final para que otras clases no puedan extenderla ya que solo son constantes
  public static final String VERSION = "v1";
  // static, pertenece a la clase en si misma, en lugar de una instancia.
  public static final String GET = "GET";
  public static final String POST = "POST";
  public static final String PUT = "PUT";
  public static final String DELETE = "DELETE";

  private Constants() { // Evitamos que se creen instancias de la clase desde fuera de la clase
    throw new IllegalArgumentException("IllegalArgumentException Constants");
  }
}
