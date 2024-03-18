package org.cortesrmzcau.webclient.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoRequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String timeInitial;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String finishTime;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String timeResponse;

    public static InfoRequest log;
    public static synchronized InfoRequest getInstance() {
        if(log == null){
            log = new InfoRequest();
        }
        return log;
    }
}
