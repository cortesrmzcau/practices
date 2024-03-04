package org.cortesrmzcau.practices.client.storeApiPlatzi;

import org.cortesrmzcau.practices.models.response.ProductsResponse;
import java.util.List;

public interface IConsumeProductsClient {
  List<ProductsResponse> consumeAPIProducts();
}
