package org.cortesrmzcau.webclient.client.impl;

import lombok.extern.log4j.Log4j2;
import org.cortesrmzcau.webclient.client.IProductsClient;
import org.cortesrmzcau.webclient.models.response.ProductsResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

/*
 * @author    cortesrmzcau
 * @project   webclient-api-platzi
 * @resume    get all products from platzi products api
 * @version   1.0.0
 * @since     17
 */
@Service
@Log4j2
public class ProductsClient implements IProductsClient {
  @Override
  public List<ProductsResponse> getProducts() {
    WebClient webClient = WebClient.builder()
                .baseUrl("https://api.escuelajs.co/api/v1")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();

    Flux<ProductsResponse> productsResponseFlux = webClient.get()
            .uri("/products")
            .retrieve()// Indica que la solicitud ha sido configurada y se debe de realizar
            .bodyToFlux(ProductsResponse.class)
            .onErrorResume(throwable -> {
              log.error("result {}", throwable.getMessage());
              throw new IllegalArgumentException("Error to getting products from api.");
            }); // bodyToFlux indica que se toma la respuesta y se convierte el flujo Flux
    // Flux cuando recibes cero, uno o varios elementos en la respeusta.

    return productsResponseFlux.collectList().block();
    /* Despues de recibir todos los elementos del flujo se pasan a una lista,
    con block se espera y obtiene resultado hasta que se complete la recopilacion.
    */
  }

}
