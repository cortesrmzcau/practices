package org.cortesrmzcau.practices.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.cortesrmzcau.practices.client.IConsumeProductClient;
import org.cortesrmzcau.practices.client.IConsumeProductsClient;
import org.cortesrmzcau.practices.client.IDeleteProductClient;
import org.cortesrmzcau.practices.client.IUpdateProductClient;
import org.cortesrmzcau.practices.exceptions.ResponseStandard;
import org.cortesrmzcau.practices.models.request.ProductRequest;
import org.cortesrmzcau.practices.models.response.ProductsResponse;
import org.cortesrmzcau.practices.utils.Constants;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ComponentScan("org.cortesrmzcau.practices")
@CrossOrigin(origins = {"https://localhost:8080, https://localhost:8081, https://localhost:8082"}) //
@Tag(name = "Consume API", description = "Consume API Products")
@RequestMapping(Constants.VERSION)
@Log4j2
public class ConsumeController {
  private final ResponseStandard responseStandard;
  private final IConsumeProductsClient iConsumeProductsClient;
  private final IConsumeProductClient iConsumeProductClient;
  private final IDeleteProductClient iDeleteProductClient;
  private final IUpdateProductClient iUpdateProductClient;

  public ConsumeController(IConsumeProductsClient iConsumeProductsClient,
                           IConsumeProductClient iConsumeProductClient,
                           ResponseStandard responseStandard,
                           IDeleteProductClient iDeleteProductClient,
                           IUpdateProductClient iUpdateProductClient) {
    this.iConsumeProductsClient = iConsumeProductsClient;
    this.iConsumeProductClient = iConsumeProductClient;
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
    List<ProductsResponse> productsResponseArrayList = iConsumeProductsClient.consumeAPIProducts();
    return responseStandard.responseSuccess(HttpStatus.OK, productsResponseArrayList);
  }

  @Operation(summary = "Consume product", description = "Consume a product", tags = "Products")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "successful operation")
  })
  @GetMapping(value = "/product/{id}")
  public ResponseEntity<Object> consumeProduct(@PathVariable Long id) {
    ProductsResponse productsResponse = iConsumeProductClient.getProduct(id);
    return responseStandard.responseSuccess(HttpStatus.OK, productsResponse);
  }

  @Operation(summary = "Delete product", description = "Delete a product", tags = "Products")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "successful operation")
  })
  @DeleteMapping(value = "/product/{id}")
  public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {
    boolean delete = iDeleteProductClient.deleteProduct(id);

    if (delete) {
      return responseStandard.responseSuccess(HttpStatus.OK, "Product deleted");
    }
    else {
      return responseStandard.reponseNotFound(HttpStatus.NOT_FOUND, "Product not found");
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
      return responseStandard.reponseNotFound(HttpStatus.NOT_FOUND, "Product not found");
    }
  }
}
