package org.cortesrmzcau.practices.clients;

import org.cortesrmzcau.practices.models.response.ProductsResponse;
import java.util.List;

public interface IConsumeProductsAPIClient {
  List<ProductsResponse> consumeAPIProducts();
}
