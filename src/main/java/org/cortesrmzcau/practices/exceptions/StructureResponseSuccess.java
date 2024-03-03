package org.cortesrmzcau.practices.exceptions;

public record StructureResponseSuccess(String folio,
                                       String message,
                                       Object result) {
}