package org.cortesrmzcau.webclient.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/*
 * @author    cortesrmzcau
 * @project   webclient-api-platzi
 * @resume    class with the configuration for swagger
 * @version   1.0.0
 * @since     17
 */
@Configuration
public class OpenAPIConfig {
  @Value("${cortesrmzcau.openapi.local-url}")
  private String localUrl;
  @Value("${cortesrmzcau.openapi.dev-url}")
  private String devUrl;
  @Value("${cortesrmzcau.openapi.prod-url}")
  private String prodUrl;

  @Bean
  public OpenAPI openAPI() {
    Server serverLocal = new Server();
    serverLocal.setUrl(localUrl);
    serverLocal.setDescription("Server url in local environment");

    Server serverDev = new Server();
    serverDev.setUrl(devUrl);
    serverDev.setDescription("Server url in dev environment");

    Server serverProd = new Server();
    serverProd.setUrl(prodUrl);
    serverProd.setDescription("Server url in prod environment");

    Contact contact = new Contact();
    contact.setName("cortesrmzcau");
    contact.setEmail("cortesrmzcau@gmail.com");
    contact.setUrl("https://cortesrmzcau.com.mx");

    Info info = new Info();
    info.setTitle("Consume API Products by Platzi");
    info.setVersion("1.0.0");
    info.setContact(contact);
    info.setDescription("Demo consume API developed by platzi");

    return new OpenAPI().info(info).servers(List.of(serverLocal, serverDev, serverProd));
  }
}
