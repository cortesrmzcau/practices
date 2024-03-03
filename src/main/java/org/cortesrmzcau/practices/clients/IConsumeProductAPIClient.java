package org.cortesrmzcau.practices.clients;

import org.cortesrmzcau.practices.models.response.ProductsResponse;

public interface IConsumeProductAPIClient {
  ProductsResponse getProduct(Long id);
}
