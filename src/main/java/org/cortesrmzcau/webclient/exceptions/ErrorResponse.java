package org.cortesrmzcau.webclient.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonPropertyOrder({"message", "trace","info", "details"})
public class ErrorResponse extends CommonResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String info;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> details;
}
