package org.cortesrmzcau.webclient.exceptions;

import java.util.List;

/*
 * @author    cortesrmzcau
 * @project   webclient-api-platzi
 * @resume    model with the structure for the response other than successful
 * @version   1.0.0
 * @since     17
 */
public record StructureResponseGeneric(String folio,
                                       String message,
                                       Object result,
                                       List<String> details) {
}
