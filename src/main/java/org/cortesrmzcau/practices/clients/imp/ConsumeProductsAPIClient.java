package org.cortesrmzcau.practices.clients.imp;

import lombok.extern.log4j.Log4j2;
import org.cortesrmzcau.practices.clients.IConsumeProductsAPIClient;
import org.cortesrmzcau.practices.models.response.ProductsResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Log4j2
public class ConsumeProductsAPIClient implements IConsumeProductsAPIClient {
  @Override
  public List<ProductsResponse> consumeAPIProducts() {
    WebClient webClient = WebClient.builder()
                .baseUrl("https://api.escuelajs.co/api/v1")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();

    ParameterizedTypeReference<List<ProductsResponse>> typeReference =
              new ParameterizedTypeReference<>() {};

    Mono<List<ProductsResponse>> productsMono = webClient.get()
              .uri("/products")
              .retrieve()
              .bodyToMono(typeReference);

    return productsMono.block();
  }

}
