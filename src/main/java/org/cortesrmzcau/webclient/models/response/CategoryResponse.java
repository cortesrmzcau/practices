package org.cortesrmzcau.webclient.models.response;

/*
 * @author    cortesrmzcau
 * @project   webclient-api-platzi
 * @resume    model of the category of the products to get
 * @version   1.0.0
 * @since     17
 */
public record CategoryResponse(Long id,
                              String name,
                              String image,
                              String creationAt,
                              String updatedAt) {
}
