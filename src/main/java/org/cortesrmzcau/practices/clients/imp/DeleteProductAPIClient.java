package org.cortesrmzcau.practices.clients.imp;

import org.cortesrmzcau.practices.clients.IDeleteProductAPIClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class DeleteProductAPIClient implements IDeleteProductAPIClient {
  @Override
  public boolean deleteProduct(Long id) {
    WebClient webClient = WebClient.builder()
          .baseUrl("https://api.escuelajs.co/api/v1")
          .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
          .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
          .build();

    Mono<Boolean> productsMono = webClient.delete()
          .uri("/products/" + id)
          .retrieve()
          .bodyToMono(Boolean.class);

    return productsMono.block();
  }
}
