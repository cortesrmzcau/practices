package org.cortesrmzcau.practices.models.mapper;

import org.cortesrmzcau.practices.models.response.CategoryResponse;
import org.cortesrmzcau.practices.models.response.CategoryProductsDTOResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICategoryProductsResponse {
  @Mappings(@Mapping(target = "idCategory", source = "id"))
  CategoryProductsDTOResponse map(CategoryResponse categoryResponse);
}
