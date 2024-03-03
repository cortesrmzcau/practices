package org.cortesrmzcau.practices.exceptions;

import java.util.List;

public record StructureResponseGeneric(String folio,
                                       String message,
                                       Object result,
                                       List<String> details) {
}
