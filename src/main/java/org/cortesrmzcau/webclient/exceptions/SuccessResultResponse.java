package org.cortesrmzcau.webclient.exceptions;

/*
 * @author    cortesrmzcau
 * @project   webclient-api-platzi
 * @resume    structure for the response with result successful
 * @version   1.0.0
 * @since     17
 */
public record SuccessResultResponse(String folio,
                                   String message,
                                   Object result) {
}
