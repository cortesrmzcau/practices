package org.cortesrmzcau.webclient.exceptions;

import java.util.List;

/*
 * @author    cortesrmzcau
 * @project   webclient-api-platzi
 * @resume    structure for the response other than successful
 * @version   1.0.0
 * @since     17
 */
public record ErrorResponse(int code,
                            String message,
                            String folio,
                            String info,
                            List<String> details) {
}
