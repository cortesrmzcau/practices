package org.cortesrmzcau.webclient.client;

import org.cortesrmzcau.webclient.models.response.ProductsResponse;

/*
 * @author    cortesrmzcau
 * @project   webclient-api-platzi
 * @resume    interface to get a product from platzi products api
 * @version   1.0.0
 * @since     17
 */
public interface IProductClient {
  ProductsResponse getProduct(Long id);
}
