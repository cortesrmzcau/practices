package org.cortesrmzcau.practices.client.impl;

import lombok.extern.log4j.Log4j2;
import org.cortesrmzcau.practices.client.IConsumeProductClient;
import org.cortesrmzcau.practices.models.response.ProductsResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Log4j2
public class ConsumeProductClient implements IConsumeProductClient {
  @Override
  public ProductsResponse getProduct(Long id) {
    WebClient webClient = WebClient.builder()
            .baseUrl("https://api.escuelajs.co/api/v1")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
            .build();

    Mono<ProductsResponse> productsMono = webClient.get()
            .uri("/products/" + id)
            .retrieve()
            .bodyToMono(ProductsResponse.class);

    return productsMono.block();
  }

}
