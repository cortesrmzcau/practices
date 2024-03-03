package org.cortesrmzcau.practices.models.response;

public record Category(Long id,
                       String name,
                       String image,
                       String creationAt,
                       String updatedAt) {
}
