package org.cortesrmzcau.practices.models.mapper;

import org.cortesrmzcau.practices.models.response.CategoryProductsDTOResponse;
import org.cortesrmzcau.practices.models.response.CategoryResponse;

public class CategoryProductsResponse implements ICategoryProductsResponse {
    @Override
    public CategoryProductsDTOResponse map(CategoryResponse categoryResponse) {
        CategoryProductsDTOResponse categoryProductsDTOResponse = new CategoryProductsDTOResponse();
        categoryProductsDTOResponse.setIdCategory(categoryResponse.getId());

        return categoryProductsDTOResponse;
    }
}
