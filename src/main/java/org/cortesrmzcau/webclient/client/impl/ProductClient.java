package org.cortesrmzcau.webclient.client.impl;

import lombok.extern.log4j.Log4j2;
import org.cortesrmzcau.webclient.client.IProductClient;
import org.cortesrmzcau.webclient.exceptions.NoGetProductsException;
import org.cortesrmzcau.webclient.models.response.ProductsResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/*
 * @author    cortesrmzcau
 * @project   webclient-api-platzi
 * @resume    get a product from platzi products api
 * @version   1.0.0
 * @since     17
 */
@Service
@Log4j2
public class ProductClient implements IProductClient {
  @Override
  public ProductsResponse getProduct(Long id) {
    WebClient webClient = WebClient.builder()
            .baseUrl("https://api.escuelajs.co/api/v1")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
            .build();

    Mono<ProductsResponse> productsMono = webClient.get()
            .uri("/productsp/" + id)
            .retrieve()
            .bodyToMono(ProductsResponse.class)
            .onErrorResume(throwable -> {
              log.error("result {}", throwable.getMessage());
              throw new NoGetProductsException("Error to getting the product from api.");
            });

    return productsMono.block();
  }

}
