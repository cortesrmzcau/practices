package org.cortesrmzcau.webclient.client;

import org.cortesrmzcau.webclient.models.request.ProductRequest;
import org.cortesrmzcau.webclient.models.response.ProductsResponse;

/*
 * @author    cortesrmzcau
 * @project   webclient-api-platzi
 * @resume    interface to update a product from platzi products api
 * @version   1.0
 * @since     17
 */
public interface IUpdateProductClient {
  ProductsResponse updateProduct(Long id, ProductRequest productRequest);
}
