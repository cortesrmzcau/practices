package org.cortesrmzcau.practices.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.cortesrmzcau.practices.clients.IConsumeProductAPIClient;
import org.cortesrmzcau.practices.clients.IConsumeProductsAPIClient;
import org.cortesrmzcau.practices.clients.IDeleteProductAPIClient;
import org.cortesrmzcau.practices.exceptions.ResponseStandard;
import org.cortesrmzcau.practices.models.response.ProductsResponse;
import org.cortesrmzcau.practices.utils.Constants;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ComponentScan("org.cortesrmzcau.practices")
@CrossOrigin(origins = "https://localhost:8080")
@Tag(name = "Consume API", description = "Consume API Products")
@RequestMapping(Constants.VERSION)
@Log4j2
public class ConsumeController {
  private final ResponseStandard responseStandard;
  private final IConsumeProductsAPIClient consumeProductsAPIClient;
  private final IConsumeProductAPIClient consumeProductAPIClient;
  private final IDeleteProductAPIClient deleteProduct;

  public ConsumeController(IConsumeProductsAPIClient consumeProductsAPIClient,
                           IConsumeProductAPIClient consumeProductAPIClient,
                           ResponseStandard responseStandard,
                           IDeleteProductAPIClient deleteProduct) {
    this.consumeProductsAPIClient = consumeProductsAPIClient;
    this.consumeProductAPIClient = consumeProductAPIClient;
    this.responseStandard = responseStandard;
    this.deleteProduct = deleteProduct;
  }

  @Operation(summary = "Consume products", description = "Consume all products", tags = "Products")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "successful operation")
  })
  @GetMapping(value = "/products")
  public ResponseEntity<Object> consumeProducts() {
    List<ProductsResponse> productsResponseArrayList = consumeProductsAPIClient.consumeAPIProducts();
    return responseStandard.responseSuccess(HttpStatus.OK, productsResponseArrayList);
  }

  @Operation(summary = "Consume product", description = "Consume a product", tags = "Products")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "successful operation")
  })
  @GetMapping(value = "/product/{id}")
  public ResponseEntity<Object> consumeProduct(@PathVariable Long id) {
    ProductsResponse productsResponse = consumeProductAPIClient.getProduct(id);
    return responseStandard.responseSuccess(HttpStatus.OK, productsResponse);
  }

  @Operation(summary = "Delete product", description = "Delete a product", tags = "Products")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "successful operation")
  })
  @DeleteMapping(value = "/product/{id}")
  public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {
    boolean delete = deleteProduct.deleteProduct(id);

    if (delete) {
      return responseStandard.responseSuccess(HttpStatus.OK, "Product deleted");
    }
    else {
      return responseStandard.reponseNotFound(HttpStatus.BAD_REQUEST, "Product not found");
    }
  }
}
