package org.cortesrmzcau.webclient.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.cortesrmzcau.webclient.client.IProductClient;
import org.cortesrmzcau.webclient.client.IProductsClient;
import org.cortesrmzcau.webclient.client.IDeleteProductClient;
import org.cortesrmzcau.webclient.client.IUpdateProductClient;
import org.cortesrmzcau.webclient.exceptions.NoGetProductsException;
import org.cortesrmzcau.webclient.exceptions.ResponseStandard;
import org.cortesrmzcau.webclient.models.request.ProductRequest;
import org.cortesrmzcau.webclient.models.response.ProductsResponse;
import org.cortesrmzcau.webclient.utils.Constants;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/*
 * @author    cortesrmzcau
 * @project   webclient-api-platzi
 * @resume    controller for consume the api by platzi
 * @version   1.0.0
 * @since     17
 */
@RestController
@ComponentScan("org.cortesrmzcau.webclient")
@CrossOrigin(origins = {"https://localhost:8080, https://localhost:8081, https://localhost:8082"}) //
@Tag(name = "Tag General Consume API by Platzi", description = "Consume API Products")
@RequestMapping(Constants.VERSION)
@Log4j2
public class ConsumeController {
  private final ResponseStandard responseStandard;
  private final IProductsClient iProductsClient;
  private final IProductClient iProductClient;
  private final IDeleteProductClient iDeleteProductClient;
  private final IUpdateProductClient iUpdateProductClient;

  public ConsumeController(IProductsClient iProductsClient,
                           IProductClient iProductClient,
                           ResponseStandard responseStandard,
                           IDeleteProductClient iDeleteProductClient,
                           IUpdateProductClient iUpdateProductClient) {
    this.iProductsClient = iProductsClient;
    this.iProductClient = iProductClient;
    this.responseStandard = responseStandard;
    this.iDeleteProductClient = iDeleteProductClient;
    this.iUpdateProductClient = iUpdateProductClient;
  }

  @Operation(summary = "Consume products", description = "Consume all products", tags = "Products")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "successful operation")
  })
  @GetMapping(value = "/products")
  public ResponseEntity<Object> consumeProducts() {
    try {
      List<ProductsResponse> productsResponseArrayList = iProductsClient.getProducts();
      return responseStandard.responseSuccess(HttpStatus.OK, productsResponseArrayList);
    }
    catch (NoGetProductsException exception) {
      log.error("Error to getting products from api.", exception);
      return responseStandard.reponseNotFound(HttpStatus.NOT_FOUND, Collections.singletonList("Error to getting products from api."));
    }
  }

  @Operation(summary = "Consume product", description = "Consume a product", tags = "Products")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "successful operation.")
  })
  @GetMapping(value = "/product/{id}")
  public ResponseEntity<Object> consumeProduct(@PathVariable Long id) {
    try {
      ProductsResponse productsResponse = iProductClient.getProduct(id);
      return responseStandard.responseSuccess(HttpStatus.OK, productsResponse);
    }
    catch (NoGetProductsException exception) {
      log.error("Error to getting product from api.", exception);
      return responseStandard.reponseNotFound(HttpStatus.NOT_FOUND, Collections.singletonList("Error to getting product from api."));
    }
  }

  @Operation(summary = "Delete product", description = "Delete a product", tags = "Products")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "successful operation")
  })
  @DeleteMapping(value = "/product/{id}")
  public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {
    boolean delete = iDeleteProductClient.deleteProduct(id);

    if (delete) {
      return responseStandard.responseSuccess(HttpStatus.OK, "Product deleted.");
    }
    else {
      return responseStandard.reponseNotFound(HttpStatus.NOT_FOUND, Collections.singletonList("Product not found."));
    }
  }

  @Operation(summary = "Update product", description = "Update title product", tags = "Products")
  @ApiResponses(value = {
             @ApiResponse(responseCode = "200", description = "product updated")
          })
  @PutMapping(value = "/updateProduct/{id}")
  public ResponseEntity<Object> updateProduct(
          @PathVariable Long id,
          @RequestBody ProductRequest productRequest) {
    ProductsResponse updateProduct = iUpdateProductClient.updateProduct(id, productRequest);

    if (updateProduct != null) {
      return responseStandard.responseSuccess(HttpStatus.OK, updateProduct);
    }
    else {
      return responseStandard.reponseNotFound(HttpStatus.NOT_FOUND, Collections.singletonList("Product not found."));
    }
  }
}
