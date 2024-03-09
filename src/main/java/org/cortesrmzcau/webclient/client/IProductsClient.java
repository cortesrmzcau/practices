package org.cortesrmzcau.webclient.client;

import org.cortesrmzcau.webclient.models.response.ProductsResponse;
import java.util.List;

/*
 * @author    cortesrmzcau
 * @project   webclient-api-platzi
 * @resume    interface to get all products from platzi products api
 * @version   1.0.0
 * @since     17
 */
public interface IProductsClient {
  List<ProductsResponse> getProducts();
}
