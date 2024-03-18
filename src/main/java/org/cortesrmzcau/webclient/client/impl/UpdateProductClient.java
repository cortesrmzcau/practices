package org.cortesrmzcau.webclient.client.impl;

import lombok.extern.log4j.Log4j2;
import org.cortesrmzcau.webclient.client.IUpdateProductClient;
import org.cortesrmzcau.webclient.models.request.ProductRequest;
import org.cortesrmzcau.webclient.models.response.ProductsResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/*
 * @author    cortesrmzcau
 * @project   webclient-api-platzi
 * @resume    update a product from platzi products api
 * @version   1.0
 * @since     17
 */
@Service
@Log4j2
public class UpdateProductClient implements IUpdateProductClient {
  @Override
  public ProductsResponse updateProduct(Long id, ProductRequest productRequest) {
      WebClient webClient = WebClient.builder()
              .baseUrl("https://api.escuelajs.co/api/v1")
              .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
              .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
              .build();

      Mono<ProductsResponse> productsResponse = webClient.put()
              .uri("/products/" + id)
              .body(Mono.just(productRequest), ProductRequest.class)
              .retrieve()
              .bodyToMono(ProductsResponse.class)
              .onErrorResume(throwable -> {
                  log.error("result {}", throwable.getMessage());
                  throw new IllegalArgumentException("Error to update product.");
              });

      return productsResponse.block();
  }
}
