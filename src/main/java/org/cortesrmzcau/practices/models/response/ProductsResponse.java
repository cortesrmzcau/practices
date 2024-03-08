package org.cortesrmzcau.practices.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsResponse {
  private Long id;
  private String title;
  private int price;
  private String description;
  private List<String> images;
  private String creationAt;
  private String updatedAt;
  private Category category;
}
