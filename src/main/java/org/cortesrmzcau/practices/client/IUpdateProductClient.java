package org.cortesrmzcau.practices.client;

import org.cortesrmzcau.practices.models.request.ProductRequest;
import org.cortesrmzcau.practices.models.response.ProductsResponse;

public interface IUpdateProductClient {
  ProductsResponse updateProduct(Long id, ProductRequest productRequest);
}
