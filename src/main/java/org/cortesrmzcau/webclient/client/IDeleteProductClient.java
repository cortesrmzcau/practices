package org.cortesrmzcau.webclient.client;

/*
 * @author    cortesrmzcau
 * @project   webclient-api-platzi
 * @resumen   interface to remove a product from platzi products api
 * @version   1.0
 * @since     17
 */
public interface IDeleteProductClient {
  boolean deleteProduct(Long id);
}
