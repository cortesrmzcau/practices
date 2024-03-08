package org.cortesrmzcau.practices.client.impl;

import org.cortesrmzcau.practices.client.IDeleteProductClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
public class DeleteProductClient implements IDeleteProductClient {
  @Override
  public boolean deleteProduct(Long id) {
    WebClient webClient = WebClient.builder()
            .baseUrl("https://api.escuelajs.co/api/v1")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
            .build();

      var resultWebClient = webClient.delete()
            .uri("/products/" + id)
            .retrieve()
            .bodyToMono(Void.class)
            .thenReturn(true)
            .onErrorResume(WebClientResponseException.class, ex -> {
                if (ex.getStatusCode().is4xxClientError()) {
                  return Mono.just(false);
                } else {
                  return Mono.error(ex);
                }
              }).block();

      if(resultWebClient != null) {
        return resultWebClient;
      }
      else {
        throw new NullPointerException("The result is null");
      }
  }
}
