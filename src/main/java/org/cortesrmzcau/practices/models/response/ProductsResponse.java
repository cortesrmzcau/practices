package org.cortesrmzcau.practices.models.response;

import java.util.List;

public record ProductsResponse(Long id,
                               String title,
                               int price,
                               String description,
                               List<String> images,
                               String creationAt,
                               String updatedAt,
                               Category category
                               ) {
}
