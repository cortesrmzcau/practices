package org.cortesrmzcau.practices.models.config;

import org.cortesrmzcau.practices.models.mapper.ICategoryProductsResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapStructConfig {
  @Bean
  public ICategoryProductsResponse mapStructMapper() {
      return ICategoryProductsResponse.INSTANCE;
  }
}
