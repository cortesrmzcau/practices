package org.cortesrmzcau.practices.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryProductsResponse {
    private Long idCategory;
    private String name;
    private String image;
    private String creationAt;
    private String updatedAt;
}
