package org.cortesrmzcau.practices.client.storeApiPlatzi.impl;

import org.cortesrmzcau.practices.client.storeApiPlatzi.IUpdateProductClient;
import org.cortesrmzcau.practices.models.request.ProductRequest;
import org.cortesrmzcau.practices.models.response.ProductsResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class UpdateProductClient implements IUpdateProductClient {
  @Override
  public ProductsResponse updateProduct(Long id, ProductRequest productRequest) {
      WebClient webClient = WebClient.builder()
              .baseUrl("https://api.escuelajs.co/api/v1")
              .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
              .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
              .build();

      return webClient.put()
              .uri("/products/" + id)
              .body(Mono.just(productRequest), ProductRequest.class)
              .retrieve()
              .bodyToMono(ProductsResponse.class).block();
  }
}
