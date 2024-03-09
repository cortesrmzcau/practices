package org.cortesrmzcau.webclient.exceptions;

/*
 * @author    cortesrmzcau
 * @project   webclient-api-platzi
 * @resume    model with the structure for the response successful
 * @version   1.0.0
 * @since     17
 */
public record StructureResponseSuccess(String folio,
                                       String message,
                                       Object result) {
}