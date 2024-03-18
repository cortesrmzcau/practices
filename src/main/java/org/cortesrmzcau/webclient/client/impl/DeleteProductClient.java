package org.cortesrmzcau.webclient.client.impl;

import lombok.extern.log4j.Log4j2;
import org.cortesrmzcau.webclient.client.IDeleteProductClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

/*
 * @author    cortesrmzcau
 * @project   webclient-api-platzi
 * @resume    remove a product from platzi products api
 * @version   1.0.0
 * @since     17
 */
@Service
@Log4j2
public class DeleteProductClient implements IDeleteProductClient {
  @Override
  public boolean deleteProduct(Long id) {
    WebClient webClient = WebClient.builder()
            .baseUrl("https://api.escuelajs.co/api/v1")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
            .build();

      Mono<Boolean> resultWebClient = webClient.delete()
            .uri("/products/" + id)
            .retrieve()
            .bodyToMono(Void.class)
            .thenReturn(true)
            .onErrorResume(throwable -> {
              log.error("result {}", throwable.getMessage());
              throw new IllegalArgumentException("Error to delete product.");
            });

      return Boolean.TRUE.equals(resultWebClient.block());
  }
}
