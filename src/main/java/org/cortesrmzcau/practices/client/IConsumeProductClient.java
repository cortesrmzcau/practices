package org.cortesrmzcau.practices.client;

import org.cortesrmzcau.practices.models.response.ProductsResponse;

public interface IConsumeProductClient {
  ProductsResponse getProduct(Long id);
}
