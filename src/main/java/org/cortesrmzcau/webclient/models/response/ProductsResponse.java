package org.cortesrmzcau.webclient.models.response;

import java.util.List;

/*
 * @author    cortesrmzcau
 * @project   webclient-api-platzi
 * @resume    model of the products to get
 * @version   1.0.0
 * @since     17
 */
public record ProductsResponse(Long id,
                               String title,
                               int price,
                               String description,
                               List<String> images,
                               String creationAt,
                               String updatedAt,
                               CategoryResponse category) {
}
