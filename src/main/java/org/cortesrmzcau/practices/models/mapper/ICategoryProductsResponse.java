package org.cortesrmzcau.practices.models.mapper;

import org.cortesrmzcau.practices.models.response.Category;
import org.cortesrmzcau.practices.models.response.CategoryProductsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ICategoryProductsResponse {
  ICategoryProductsResponse INSTANCE = Mappers.getMapper(ICategoryProductsResponse.class);

  @Mappings(@Mapping(target = "idCategory", source = "id"))
  CategoryProductsResponse map(Category category);
}
