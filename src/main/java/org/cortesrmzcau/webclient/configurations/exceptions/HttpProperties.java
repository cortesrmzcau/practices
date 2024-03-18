package org.cortesrmzcau.webclient.configurations.exceptions;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "http-response")
@Data
public class HttpProperties {
  private String developer;
}
