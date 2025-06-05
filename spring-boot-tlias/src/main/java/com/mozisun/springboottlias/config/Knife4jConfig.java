package com.mozisun.springboottlias.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Knife4jConfig {

  @Bean
  public OpenAPI springDocOpenAPI() {
    return new OpenAPI()
        .info(new Info()
                  .title("Tiles API 接口文档")
                  .description("提供 Tiles API 接口文档 ")
                  .version("v1.0.0")
                  .contact(new Contact()
                               .name("moZi")
                               .url("https://github.com/sunMozi")
                               .email("2138844072@qq.com")
                  )
        )
        .externalDocs(new ExternalDocumentation()
                          .description("项目地址")
                          .url("https://github.com/sunMozi/spring-boot-module"));
  }
}
