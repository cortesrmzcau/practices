package org.cortesrmzcau.practices.client.storeApiPlatzi;

import org.cortesrmzcau.practices.models.response.ProductsResponse;

public interface IConsumeProductClient {
  ProductsResponse getProduct(Long id);
}
